//malloc in Pointers
#include<stdio.h>
#include<stdlib.h>
int main()
{
    //void* malloc(size_t size)
    int i,n;
    printf("\nEnter The Limit : ");
    scanf("%d",&n);
    int *ptr=(int *)malloc(n*sizeof(int));
    if(ptr==NULL)
    {
          printf("Memory Not Available ...");
          exit(1);
    }
    for(i=0; i<n; i++)
    {
        printf("Enter a integer : ");
        scanf("%d",ptr+i);
    }
    for(i=0;i<n;i++)
    {
        printf("%d  ",*(ptr+i));  // ptr+1
        printf("\n%d",i);
    }

    return 0;
}
