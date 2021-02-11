
#include <stdio.h> 
#include <stdlib.h> 
  
struct Dugum{ 
    int veri; 
    struct Dugum* next; 
}; 

void listegiYazdir(struct Dugum* n) 
{ 
    while (n != NULL) { 
        printf(" %d ", n->veri); 
        n = n->next; 
    } 
} 
  
int main() 
{ 
    struct Node* head = NULL; 
    struct Node* second = NULL; 
    struct Node* third = NULL; 
  
    // allocate 3 nodes in the heap 
    head = (struct Node*)malloc(sizeof(struct Dugum)); 
    second = (struct Node*)malloc(sizeof(struct Dugum)); 
    third = (struct Node*)malloc(sizeof(struct Dugum)); 
  
    head->veri = 1; // assign data in first node 
    head->next = second; 
  
    second->veri = 2; // assign data to second node 
    second->next = third; 
  
    third->veri = 3; // assign data to third node 
    third->next = NULL; 
  
    listegiYazdir(head); 
  
    return 0; 
}