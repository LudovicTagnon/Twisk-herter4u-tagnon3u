CC = gcc
CFLAGS = -Wall -fPIC 
DFLAGS = -shared
MAINFLAGS = -Wall -L. 
EXEC = main
CLIENT = client7E2G
LISTECLIENT = client.o client5E1G.o client7E2G.o

all: $(EXEC)

$(EXEC): main.c libTwisk.so
	@$(CC) $(MAINFLAGS) $^ -o $@ -lTwisk

libTwisk.so: programmeC.o $(CLIENT).o
	@$(CC) $(DFLAGS) $^ -o $@ 
	export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:.

$(CLIENT).o: $(CLIENT).c
	@$(CC) $(CFLAGS) -c $^ 

clean:
	@rm -f $(LISTECLIENT) $(EXEC)
mrproper:
	@rm -f libTwisk.so