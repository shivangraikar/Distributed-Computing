import java.util.*; import java.lang.Math;

class vector{
public static void main(String[] args)
{

System.out.println("Enter No.of Processes:"); 
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
// System.out.print(n); 
int ne [] = new int[n];
int status[][] = new int[n][10];
int prevp[][] = new int[n][10];
int preve[][] = new int[n][10]; for ( int i = 0; i<n;i++)
{

System.out.print("Enter no. of events of Process "+(i+1)+": "); ne[i] = sc.nextInt();
System.out.println("Enter 0 for Internal, 1 for Send, 2 for Receive"); for (int j = 0; j < ne[i]; j++)
{


if((status[i][j] != 1) && (status[i][j] !=2))
{

System.out.print("Event "+(j+1)+": "); status[i][j]= sc.nextInt();
if(status[i][j] == 1)
{
 
System.out.print("Enter Receiving Process: "); int a = sc.nextInt();
System.out.print("Enter Receiving Event: "); int b = sc.nextInt();
status[(a-1)][(b-1)] = 2;


prevp[i][j] = 0;preve[i][j] = -1;
prevp[(a-1)][(b-1)] = i;
preve[(a-1)][(b-1)] = j;
}

else if(status[i][j] == 2)
{

System.out.print("Enter Sending Process: "); int a = sc.nextInt();
System.out.print("Enter Sending Event: "); int b = sc.nextInt();
status[(a-1)][(b-1)] = 1;


prevp[i][j] = (a-1);preve[i][j] = (b-1);
prevp[(a-1)][(b-1)] = -1;
preve[(a-1)][(b-1)] = -1;


}
else
{

prevp[i][j] = 0;preve[i][j] = 0; continue;
}
 
}
else {
continue;

}
}
}

System.out.println();


int time[][] = new int[n][10];


for(int x = n-1; x>-1;x--)
{

for(int z=0;z<ne[x];z++)
{

time[x][z] = 0;
int p = (int)Math.pow(10,(n-(x+1))); if(z == 0)
{

time[x][z] = p;
}

else{
time[x][z] = p + time[x][(z-1)];

}


if(status[x][z] == 2)
{

if ( x == n-1)
 
{
int sum = ((time[(prevp[x][z])][(preve[x][z])])/10); sum = sum*10;
time[x][z] = sum + time[x][z];
}

else if( x == 0 ) {
int sum = ((time[(prevp[x][z])][(preve[x][z])])%p); time[x][z] = sum + time[x][z];
}
else
time[x][z] = (time[(prevp[x][z])][(preve[x][z])] + time[x][z]);
}


}


}


for(int x1 =n-1; x1 > -1; x1--)
{

for(int z1 =0;z1 <ne[x1]; z1 ++)
{

int p = (int)Math.pow(10,(n-(x1+1)));


if(z1 != 0)
{

time[x1][z1] = p + time[x1][(z1-1)];
}

else{
 
time[x1][z1] = p;
}


if(status[x1][z1] == 2)
{

if ( x1 == n-1)
{

int sum = ((time[(prevp[x1][z1])][(preve[x1][z1])])/10); sum = sum*10;
time[x1][z1] = sum + time[x1][z1];
}

else if( x1 == 0 ) {
int sum = ((time[(prevp[x1][z1])][(preve[x1][z1])])%p); time[x1][z1] = sum + time[x1][z1];
}
else
time[x1][z1] = (time[(prevp[x1][z1])][(preve[x1][z1])] + time[x1][z1]);
}
}
}


System.out.println("Vector Clocks");


for(int q =0; q<n;q++)
{

System.out.print("Process "+(q+1)+"\t"); for(int p=0;p<ne[q];p++)
{

String format = ("%0"+n+"d");
 
System.out.print((String.format(format, time[q][p]))+"\t");
}

System.out.println();
}


}
}

