CC = gcc
CFLAGS = -Wall -fPIC 
DFLAGS = -shared
MAINFLAGS = -Wall -L. 
EXEC = main

all: $(EXEC)

$(EXEC): main.c libTwisk.so
	@$(CC) $(MAINFLAGS) $^ -o $@ -lTwisk

libTwisk.so: programmeC.o client.o
	@$(CC) $(DFLAGS) $^ -o $@ 
	export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:.

client.o: client.c
	@$(CC) $(CFLAGS) -c $^ 

clean:
	@rm -f client.o

mrproper:
	@rm -f libTwisk.so