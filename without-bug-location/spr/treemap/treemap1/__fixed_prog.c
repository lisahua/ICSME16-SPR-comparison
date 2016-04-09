#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Entry {
    struct Entry* parent;
    struct Entry* left;
    struct Entry* right;
    char* value;
    int color;
};

struct TreeMap {
    struct Entry* root;
    int size;
};

void newEntry(struct Entry** n);
void newTreeMap(struct TreeMap** t);
void getFirstEntry(struct TreeMap** tree, struct Entry** p);
void successor(struct Entry** t, struct Entry** p);
int containsValue(struct Entry* root, char* value);
void buildFromSorted (int level, int lo, int hi, int redLevel, char** value, struct Entry** res);
void buildTree(int size, char** value, struct Entry** root) ;
int val_i;

void newEntry(struct Entry** n) {
     *n = malloc (sizeof (struct Entry));
    (*n)->parent = NULL;
    (*n)->left = NULL;
    (*n)->right = NULL;
    (*n)->color = 1;
    (*n)->value = NULL;
}

void newTreeMap(struct TreeMap** t) {
    *t = malloc(sizeof (struct TreeMap));
    (*t)->root = NULL;
    (*t)->size = 0;
}

void getFirstEntry(struct TreeMap** tree, struct Entry** p) {
    *p = (*tree)->root;
    if ((*p)!=NULL) {
        while ((*p)->left != NULL)
            *p = (*p)->left;
    }
    return ;
}

void successor(struct Entry** t, struct Entry** p) {
    if ((*t)==NULL) {
        (*p)=NULL;
        return;
    }else if ((*t)->left !=NULL) {
        *p = (*t)->right;
        while ((*p)->left != NULL)
            *p = (*p)->left;
        return;
    } else {
        *p = (*t)->parent;
        struct Entry* ch = *t;
        while (((*p) != NULL) && (ch ==(*p)->right)) {
            ch = *p;
            *p = (*p)->parent;
        }
        return;
    }
}

int containsValue(struct Entry* root, char* value) {
    struct Entry* e = root;
//    printf("contains value %s root %s, %d",value, e->value,strcmp(value, e->value));
    if (e !=NULL) {
        while (e->left != NULL)
            e = e->left;
    }

    int cnt = 0;
    while ((e!= NULL)&& (cnt<10)) {
        cnt++;
        if ((value ==NULL && e->value == NULL) || (strcmp(value, e->value)==0))
            return 0;

        if ((e->right) != NULL) {
            struct Entry* p = e->right;
            while ((p->left != NULL))
                p = p->left;
            e = p;
        }

        else {
            struct Entry* ch = e;

            struct Entry* p = e->parent;
            // BUG RBTERR1
            while ((p!=NULL) && (p->left == NULL)) {
                ch = p;
                p = p->parent;
            }
            e=p;
        }
    }
   // if (cnt==10)
     //   return 1;
    return 1;
}

void buildFromSorted (int level, int lo, int hi, int redLevel, char** value, struct Entry** res) {
    if (hi < lo) {
        *res = NULL;
        return;
    }
    int mid = (lo+hi)/2;
    struct Entry* left = NULL;
    if (lo < mid)
         buildFromSorted(level+1, lo, mid-1,redLevel, value, &left);

    struct Entry* middle;
    newEntry(&middle);
//     printf("build sort middle value %s, %s,",value[0],value[val_i]);
    middle->value = value[val_i++];


    if (level==redLevel)
        middle->color = 0;
    //prophet generated patch
    if ((left != ((void *)0)) && !(left->left != 0)) {
        middle->left = left;
        left->parent = middle;
    }

    if (mid < hi) {
        struct Entry* right;
        buildFromSorted(level+1,mid+1,hi, redLevel, value, &right);
        middle->right = right;
        right->parent = middle;
    }
    *res = middle;
}

void buildTree(int size, char** value, struct Entry** root) {
    int level = 0;
    for (int m=size-1;m>=0;m=m/2-1)
        level++;

    buildFromSorted(0,0,size-1,level,value,root);
}

void printTree(struct Entry* root) {
    if (root==NULL) return;
    printf("%s ",root->value);
    printTree(root->left);
     printTree(root->right);
}
int main(int argc, char* argv[]) {
    if (argc<2) return 0;
    FILE *f = fopen(argv[1],"r");
    if (f==NULL)
        return 0;

    struct TreeMap* t;
    newTreeMap(&t);

    char x[20];
     char* input[20];
    int i=0;
    char find[10];
    fscanf(f,"%s",find);
    fscanf(f,"%s",find);
    while (fscanf(f,"%s",x)==1) {
        if (x[0]!= '"') {
            int len = strlen(x)+1;
            input[i] = (char*) malloc(len * sizeof (char));// (char*) malloc (sizeof (char*len))
           strcpy(input[i],x);
            i = i+1;
        }
    }
    fclose(f);
//    printf("size %d,",i);
    val_i = 0;
//    for (int j=0;j<i;j++)
//        printf("%s ",input[j]);

    struct Entry* root = t->root;
    buildTree(i,input,&root);
//    printf("%s ","after build tree root ");
//    printTree(root);
    int res = containsValue(root, find);
    printf("%d",res);

    return 0;
}
