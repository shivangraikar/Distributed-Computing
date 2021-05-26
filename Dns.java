import java.util.*; import java.lang.String;

class dns{
 
String subdns (String s)
{

if (s.contains(".") == true)
{

System.out.print("Now in Server: \t"); int dotloc = s.indexOf(".");
StringBuilder sb1 = new StringBuilder(s.substring(0,dotloc)); sb1.reverse();
System.out.println(sb1.toString());


dotloc++;
s = s.substring(dotloc); return subdns(s);

}


else{
StringBuilder sb1 = new StringBuilder(s); sb1.reverse();
System.out.print("Now in Server: \t"); return(sb1.toString());
}
 
}


String subdns2 (String s)
{

if (s.contains(".") == true)
{

System.out.print("Back to Server: "); int dotloc = s.indexOf(".");
System.out.println(s.substring(0,dotloc)); dotloc++;
s = s.substring(dotloc); return subdns2(s);

}


else{
System.out.print("Back to Server: "); return(s);
}
}



public static void main(String[] args)
{

Scanner sc = new Scanner(System.in); System.out.println("Enter a web address"); String ad= sc.nextLine();
 
String[] arrOfStr= ad.split("[.]");

System.out.println("\n------Iterative method	");
System.out.println();
System.out.println("Client's name resolver --> Root Name Server :\t"+ arrOfStr[arrOfStr.length-1]);
for (int i = arrOfStr.length-2; i >= 0; i--)
{

System.out.print("Client's name resolver --> Name Server node :\t"); System.out.println(arrOfStr[i]);
}

System.out.println("\nURL found");

System.out.println("\n\n------Recursive method	\n");

dns d = new dns();
StringBuilder sb = new StringBuilder(ad); sb.reverse(); System.out.println(d.subdns(sb.toString())); System.out.println();

int dotloc = ad.indexOf("."); dotloc++;
String ad2 = ad.substring(dotloc,(ad.length()));
 
System.out.println(d.subdns2(ad2));


System.out.println("\nURL found");
}

}
