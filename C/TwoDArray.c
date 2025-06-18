#include<stdio.h>
int main(){
int a[100][100],b[100][100],c[100][100];
int i,j,n,m;
printf("\nEnter the row limit");
scanf("%d", &n);
printf("\nEnter the column limit");
scanf("%d", &m);

for(i = 0;i < n; i++){
    for(j = 0;j < m; j++){
       printf("\n Enter the value of  a[%d][%d]",i , j);
       scanf("%d", &a[i][j]);
    }
        }
    for(i = 0;i < n; i++) {
    for(j = 0;j < m; j++) {
       printf("\n Enter the value of   b[%d][%d]", i, j);
        scanf("%d",&b[i][j]);
    }
    }
    for(i=0;i<n;i++) {
    for(j=0;j<m;j++) {
     c[i][j]=a[i][j]+b[i][j];

            printf("\t %d ",c[i][j]);
    }
    printf("\n");
}
return 0;
}

