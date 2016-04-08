#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node {
    struct Node* next;
    struct Node* prev;
    char* name;
};

struct List {
    struct Node* header;
    int size;
};

int repOK (struct List** t);
void newNode(struct Node** n);
void newList(struct List** t);

void newNode(struct Node** n) {
     *n = malloc (sizeof (struct Node));
    (*n)->next = NULL;
    (*n)->prev = NULL;
    (*n)->name = NULL;
}

void newList(struct List** t) {
    *t = malloc(sizeof (struct List));
    (*t)->header = NULL;
    (*t)->size = 0;
}


int repOK (struct List** list) {
    struct Node* l = (*list)->header;
    int cnt1 = 0;
    int res = 0;
    while (cnt1 < (*list)->size) {
       struct  Node* p = l->next;
        int cnt2 = cnt1+1;

  //      int cond = ((cnt2 <= (*list)->size) && (p != NULL));
        //BUG comment it out for correct version
//        cond = (cnt2 < (*list)->size);

        while (cnt2< (*list)->size) {
            if (l==p) {
                res = 1;
                return res;
            }
            cnt2++;
           // p = l->next;// BUG LISTERR3
           p = p->next;

          // cond = ((cnt2 <= (*list)->size) && (p!=NULL));
            //BUG comment out for correct version
          // cond = (cnt2 < (*list)->size);
        }
        l = l->next;
        cnt1 = cnt1 + 1;
    }
        if (res == 1)
            return res;

    struct Node* l1 = (*list)->header;
    int sz=0;
    while (l1!=NULL) {
        sz = sz+1;
        l1 = l1->next;
        if (sz > (*list)->size)
            return 0;
    }

    if (sz != (*list)->size)
        return 1;
    return 0;
}


int main(int argc, char* argv[]) {
    if (argc<2) return 0;
    FILE *f = fopen(argv[1],"r");
    if (f==NULL)
        return 0;

    char x[20];
    int status = 0;
    struct List* list ;
    newList(&list);

struct Node* n0;
struct Node* n1;
struct Node* n2;
newNode(&n0);
n0->name = "N0";
newNode(&n1);
n1->name = "N1";
newNode(&n2);
n2->name = "N2";



  struct Node* node=NULL;
    while (fscanf(f,"%s",x)==1) {
        if (x[0] == '"')  continue;

        struct Node* tmp=NULL;
        if (strcmp(x,"NULL")==0)
            tmp = NULL;
        else if (strcmp(x,"N0")==0)
            tmp = n0;
        else if (strcmp(x,"N1")==0)
            tmp = n1;
        else if (strcmp(x,"N2")==0)
            tmp = n2;

        if (status==0) {
            node = tmp;
            status = status +1;
        }
        else if (status == 1) {
            node->prev = tmp;
            status = status +1;
        }

        else if (status ==2) {
            node->next = tmp;
            status =0;
            list->size = list->size +1;
            if (list->header==NULL)
                list->header = node;

        }
    }

    fclose(f);
    int res = repOK(&list);
    printf("%d ", res);

    return 0;
}
