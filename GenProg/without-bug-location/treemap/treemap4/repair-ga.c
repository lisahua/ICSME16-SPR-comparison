struct Entry {
   struct Entry *parent ;
   struct Entry *left ;
   struct Entry *right ;
   char *value ;
   int color ;
};
struct TreeMap {
   struct Entry *root ;
   int size ;
};
void newEntry(struct Entry **n ) ;
void newTreeMap(struct TreeMap **t ) ;
void getFirstEntry(struct TreeMap **tree , struct Entry **p ) ;
void successor(struct Entry **t , struct Entry **p ) ;
int containsValue(struct Entry *root , char *value ) ;
void buildFromSorted(int level , int lo , int hi , int redLevel , char **value , struct Entry **res ) ;
void buildTree(int size , char **value , struct Entry **root ) ;
int val_i  ;
extern int ( /* missing proto */  malloc)() ;
void newEntry(struct Entry **n ) 
{ int tmp ;

  {
  tmp = malloc(sizeof(struct Entry ));
  *n = (struct Entry *)tmp;
  (*n)->parent = (struct Entry *)((void *)0);
  (*n)->left = (struct Entry *)((void *)0);
  (*n)->right = (struct Entry *)((void *)0);
  (*n)->color = 1;
  (*n)->value = (char *)((void *)0);
  return;
}
}
void newTreeMap(struct TreeMap **t ) 
{ int tmp ;

  {
  tmp = malloc(sizeof(struct TreeMap ));
  *t = (struct TreeMap *)tmp;
  (*t)->root = (struct Entry *)((void *)0);
  (*t)->size = 0;
  return;
}
}
void getFirstEntry(struct TreeMap **tree , struct Entry **p ) 
{ 

  {
  *p = (*tree)->root;
  if ((unsigned int )*p != (unsigned int )((void *)0)) {
    while ((unsigned int )(*p)->left != (unsigned int )((void *)0)) {
      *p = (*p)->left;
    }
  } else {

  }
  return;
}
}
void successor(struct Entry **t , struct Entry **p ) 
{ struct Entry *ch ;

  {
  if ((unsigned int )*t == (unsigned int )((void *)0)) {
    *p = (struct Entry *)((void *)0);
    return;
  } else {
    if ((unsigned int )(*t)->left != (unsigned int )((void *)0)) {
      *p = (*t)->right;
      while ((unsigned int )(*p)->left != (unsigned int )((void *)0)) {
        *p = (*p)->left;
      }
      return;
    } else {
      *p = (*t)->parent;
      ch = *t;
      while (1) {
        if ((unsigned int )*p != (unsigned int )((void *)0)) {
          if ((unsigned int )ch == (unsigned int )(*p)->right) {

          } else {
            break;
          }
        } else {
          break;
        }
        ch = *p;
        *p = (*p)->parent;
      }
      return;
    }
  }
}
}
extern int ( /* missing proto */  strcmp)() ;
int containsValue(struct Entry *root , char *value ) 
{ struct Entry *e ;
  int cnt ;
  int tmp ;
  struct Entry *p ;
  struct Entry *ch ;
  struct Entry *p___0 ;

  {
  e = root;
  if ((unsigned int )e != (unsigned int )((void *)0)) {
    __repair_swap1_72__ba: /* CIL Label */ 
    if ((unsigned int )e->right != (unsigned int )((void *)0)) {
      p = e->right;
      while ((unsigned int )p->left != (unsigned int )((void *)0)) {
        p = p->left;
      }
      e = p;
    } else {
      ch = e;
      p___0 = e->parent;
      while (1) {
        if ((unsigned int )p___0 != (unsigned int )((void *)0)) {
          if ((unsigned int )p___0->left == (unsigned int )((void *)0)) {

          } else {
            break;
          }
        } else {
          break;
        }
        ch = p___0;
        p___0 = p___0->parent;
      }
      e = p___0;
    }
  } else {

  }
  cnt = 0;
  while (1) {
    if ((unsigned int )e != (unsigned int )((void *)0)) {
      if (cnt < 10) {

      } else {
        break;
      }
    } else {
      break;
    }
    cnt ++;
    if ((unsigned int )value == (unsigned int )((void *)0)) {
      if ((unsigned int )e->value == (unsigned int )((void *)0)) {
        return (0);
      } else {
        goto _L;
      }
    } else {
      __repair_swap1_41__bb: /* CIL Label */ 
      _L: /* CIL Label */ ;
      if (tmp == 0) {
        return (0);
      } else {

      }
    }
    __repair_swap1_44__bc: /* CIL Label */ 
    while ((unsigned int )e->left != (unsigned int )((void *)0)) {
      e = e->left;
    }
  }
  return (1);
}
}
void buildFromSorted(int level , int lo , int hi , int redLevel , char **value , struct Entry **res ) 
{ int mid ;
  struct Entry *left ;
  struct Entry *middle ;
  int tmp ;
  struct Entry *right ;

  {
  if (hi < lo) {
    *res = (struct Entry *)((void *)0);
    return;
  } else {

  }
  mid = (lo + hi) / 2;
  left = (struct Entry *)((void *)0);
  if (lo < mid) {
    buildFromSorted(level + 1, lo, mid - 1, redLevel, value, & left);
  } else {

  }
  newEntry(& middle);
  tmp = val_i;
  val_i ++;
  middle->value = *(value + tmp);
  if (level == redLevel) {
    middle->color = 0;
  } else {

  }
  if ((unsigned int )left != (unsigned int )((void *)0)) {
    middle->left = left;
    left->parent = middle;
  } else {

  }
  if (mid < hi) {
    buildFromSorted(level + 1, mid + 1, hi, redLevel, value, & right);
    middle->right = right;
    __repair_app_100__bd: /* CIL Label */ 
    {
    right->parent = middle;
    if (level == redLevel) {
      middle->color = 0;
    } else {

    }
    }
  } else {

  }
  *res = middle;
  return;
}
}
void buildTree(int size , char **value , struct Entry **root ) 
{ int level ;
  int m ;

  {
  level = 0;
  m = size - 1;
  while (m >= 0) {
    level ++;
    m = m / 2 - 1;
  }
  buildFromSorted(0, 0, size - 1, level, value, root);
  return;
}
}
extern int ( /* missing proto */  printf)() ;
void printTree(struct Entry *root ) 
{ 

  {
  if ((unsigned int )root == (unsigned int )((void *)0)) {
    return;
  } else {

  }
  printf("%s ", root->value);
  printTree(root->left);
  printTree(root->right);
  return;
}
}
extern int ( /* missing proto */  strtok)() ;
extern int ( /* missing proto */  strlen)() ;
extern int ( /* missing proto */  strcpy)() ;
int main(int argc , char **argv ) 
{ struct TreeMap *t ;
  char *x ;
  char *input[20] ;
  int i ;
  char *find ;
  char *tmp ;
  int tmp___0 ;
  int len ;
  int tmp___1 ;
  int tmp___2 ;
  char *tkn ;
  int tmp___3 ;
  int len___0 ;
  int tmp___4 ;
  int tmp___5 ;
  int tmp___6 ;
  struct Entry *root ;
  int res ;
  int tmp___7 ;

  {
  if (argc < 2) {
    return (0);
  } else {

  }
  newTreeMap(& t);
  x = *(argv + 1);
  i = 0;
  tmp___0 = strtok(x, " ");
  tmp = (char *)tmp___0;
  tmp___1 = strlen(tmp);
  len = tmp___1 + 1;
  tmp___2 = malloc((unsigned int )len * sizeof(char ));
  find = (char *)tmp___2;
  strcpy(find, tmp);
  tmp___3 = strtok((void *)0, " ");
  tkn = (char *)tmp___3;
  while ((unsigned int )tkn != (unsigned int )((void *)0)) {
    if ((int )*(tkn + 0) == 34) {
      continue;
    } else {

    }
    tmp___4 = strlen(x);
    len___0 = tmp___4 + 1;
    tmp___5 = malloc((unsigned int )len___0 * sizeof(char ));
    input[i] = (char *)tmp___5;
    strcpy(input[i], tkn);
    i ++;
    tmp___6 = strtok((void *)0, " ");
    tkn = (char *)tmp___6;
  }
  val_i = 0;
  root = t->root;
  buildTree(i, input, & root);
  tmp___7 = containsValue(root, find);
  res = tmp___7;
  printf("%d", res);
  return (0);
}
}
