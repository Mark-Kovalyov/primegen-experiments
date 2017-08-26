#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <time.h>
#include <math.h>
#include <string>

#include <vector>

#define MAX_SIGNED_LONG64 "9223372036854775807"

//#define FLOATING_SQRT

//  Infinite Prime Generator 1.2 (c) sql.ru
// 
//  2009.05.02   -    Mayton
//
//  2009.05.02   -    Mayton   - увеличил разрядность основных типов данных до 64-bit
//                               необходимо проверить, как работает функция (uint64_t)sqrt((double)c1)
//                               Не будет-ли потери точности?
//
//                             - добавил console-like интерфейс
// 
//  2015.04.01   -    Mayton   - ported into MinGW (GCC 4.8.1) Win64 compiller
//  2015.04.02   -    Mayton   - added isqrt64(..) for integer square root. 
//                               added twin primes
//  2015.04.02   -    Mayton   - improovement speed of main loop. Added non linear step. 
//                               (Thnx to DimaT).
//  2015.04.04   -    Mayton   - added triplet count
//  2017.08.26   -    Mayton   - remove garbage, improove comments.

// TODO: Fix more bugs!

using namespace std;

uint64_t isqrt64(uint64_t x) {	
	uint64_t x1;
	uint64_t s, g0, g1;
	if (x <= 1) return x;
	s = 1;
	x1 = x - 1;
	// TODO: Is it possible to RIGHT SHIFT by 32 bit for MinGW ?
        if (x1 > 0x100000000 - 1)     { s+=16; x1>>=32;}
	if (x1 > 0x10000     - 1)     { s+=8;  x1>>=16;}
	if (x1 > 0x100       - 1)     { s+=4;  x1>>=8; }
	if (x1 > 0x10        - 1)     { s+=2;  x1>>=4; }
	if (x1 > 3)                   { s+=1; }
	g0 = 1<<s;
	g1 = (g0 + (x >> s)) >> 1;
	while(g1 < g0) {
		g0 = g1;
		g1 = (g0 + (x/g0)) >> 1;
	}
	return g0;
}

vector<uint64_t> primesCache;

// TODO: Should be captured signal Ctlr+C to save state machine for contonuation ability.
int main(int argc, char* argv[], char* env[]) {

	int time1 = time(NULL);

        int twin_primes = 0;

        int triplet_primes = 0;

	uint64_t max_prime = 2;

	if (argc >= 2) {
                std::string arg1(argv[1]);
                if (arg1.length() > 19 || arg1 > MAX_SIGNED_LONG64 ) {
                     fprintf(stderr, "The argument '%s' is greather than maximum 64bit integer value. Please try less!", arg1.c_str());
                     return 0;
                }
		max_prime = atol(argv[1]);
		//max_prime = static_cast<uint64_t>(arg1);
	} else {
		printf("\nInfinite Prime Generator 1.2 (x64) (c) sql.ru, Aug 2017\n");
		printf("Usage:\n\n");
		printf(" pbfa64 <maxPrime> [options] [ > outputFile.lst ]\n");
		//printf("Where options:\n");
		//printf(" -d   : dense print (width=80 symbols)\n");
		//printf(" -s c : split with symbol c\n");
		//printf(" -p : persist primes cache into datafiles c\n");
		return 0;
	}

	primesCache.push_back(2);
	primesCache.push_back(3);

	printf("2\n");
	printf("3\n");

	uint64_t min_prime = 5;

	uint64_t primes = 2;

	uint64_t c2 = 0;

	uint64_t c3 = 0;

	int echo_count = 0;

	int mersenne_primes = 0;

	uint64_t interval = max_prime - min_prime;

	uint64_t step = 4;

	for (uint64_t c1 = min_prime; c1 <= max_prime; c1 += step) {
		step^=0x0006;
		if (++echo_count > 1000000) {
			fprintf(stderr, "Completed: %d %%\n",
					(int) (100.0 * (c1 - min_prime) / (double) interval));
			echo_count = 0;
		}

		bool isprime = true;
		// TODO: What is the reason to calculate SQRT every step? Should be replaced by linear approximation.
#ifdef FLOATING_SQRT
		uint64_t ub = 1 + (uint64_t ) sqrt((double) c1); // What is the interval of casting uint64_t -> double?
#else
		uint64_t ub = 1 + isqrt64(c1); 
#endif
		
		uint64_t i = 1; // Starting from 3 because of even are absent

                int size = primesCache.size();

		while (i < size) {
			if ((c1 % primesCache[i]) == 0) {
				isprime = false;
				break;
			}
			if (primesCache[i] >= ub)
				break;
			i++;
		}
		if (isprime) {
			printf("%llu\n",c1);
			if (c1 - c2 == 2) twin_primes++;
			uint64_t d = c2 - c3;
			if ( ( d == 2 || d == 4 ) && ( c1 - c3 == 6 ) ) triplet_primes++;
			c3 = c2;
			c2 = c1;                                                                                                                   
			primesCache.push_back(c1);
			primes++;
		}
	}

	int timeElapsed = time(NULL) - time1;
	fprintf(stderr, "\n");
	fprintf(stderr, "Primes detected      : %d\n",           primes);
	fprintf(stderr, "Twin primes          : %d\n",           twin_primes);
        fprintf(stderr, "Triplet primes       : %d\n",           triplet_primes);
	fprintf(stderr, "Range                : [2..%llu]\n",      max_prime);
	fprintf(stderr, "Memory cache used    : %d K\n",         (sizeof(uint64_t ) * primesCache.capacity()) / 1024);
#ifdef FLOATING_SQRT
	fprintf(stderr, "Square root algorithm: math::sqrt(double)\n");
#else
	fprintf(stderr, "Square root algorithm: Henry Warren's 'isqrt64'\n");
#endif
	fprintf(stderr, "AVG speed generation : %d units/sec\n", (timeElapsed == 0) ? 0 : primes / timeElapsed);
	fprintf(stderr, "Elapsed time         : %d sec\n",       timeElapsed);

	primesCache.clear();

	return 0;
}
