#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CONST 20

char * translateWord(char * temp){
    char * tempTranslated = (char*)malloc(sizeof(char)*strlen(temp));
    for (int i = 0; i < strlen(temp); i++)
    {
        tempTranslated[i] = temp[strlen(temp)-i-1];
    }
    return tempTranslated; 
}


int main(int argc, char const *argv[])
{
    char * word_s, *word_t;
    word_s = (char*)malloc(sizeof(char) * CONST);
    word_t = (char*)malloc(sizeof(char) * CONST);

    scanf("%s", word_s);
    scanf("%s", word_t);

    if(strcmp(word_t, translateWord(word_s)) == 0){
        printf("YES\n");
    }
    else printf("NO\n");

    free(word_s);
    free(word_t);
    return 0;
}
