
#include <stdio.h> 
#include <stdlib.h> 
  
struct Dugum{ 
    int veri; 
    struct Dugum* sonraki; 
}; 

void listegiYazdir(struct Dugum* n) 
{ 
    while (n != NULL) { 
        printf(" %d ", n->veri); 
        n = n->sonraki; 
    } 
} 
  
int main() 
{ 
    struct Node* bas= NULL; 
    struct Node* ikinci= NULL; 
    struct Node* ucuncu= NULL; 
  
    // allocate 3 nodes in the heap 
    bas= (struct Node*)malloc(sizeof(struct Dugum)); 
    ikinci = (struct Node*)malloc(sizeof(struct Dugum)); 
    ucuncu= (struct Node*)malloc(sizeof(struct Dugum)); 
  
    bas>veri = 1; // assign data in first node 
    bas>sonraki = second; 
  
    ikinci ->veri = 2; // assign data to second node 
    sikinci ->sonraki = third; 
  
    ucuncu->veri = 3; // assign data to third node 
    ucuncu->sonraki = NULL; 
  
    listegiYazdir(head); 
  
    return 0; 
}