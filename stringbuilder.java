public class stringbuilder {
    public static void main(String[] args){
    StringBuilder sb = new StringBuilder("Hello");

// modify
sb.append(" World");         // Hello World
System.out.println(sb);
sb.insert(5, ",");            // Hello, World
System.out.println(sb);

sb.delete(5, 6);              // Hello World
System.out.println(sb);

sb.replace(6, 11, "Java");    // Hello Java
System.out.println(sb);

sb.reverse();                 // avaJ olleH
System.out.println(sb);

sb.reverse();                 // Hello Java (back again)
System.out.println(sb);

// access
char c = sb.charAt(0);        // 'H'
System.out.println(c);

String sub = sb.substring(6); // "Java"
System.out.println(sub);

// capacity/length
int len = sb.length();        // 10
System.out.println(len);

int cap = sb.capacity();      // default 16 + string length
System.out.println(cap);

sb.ensureCapacity(5);

// final string
String result = sb.toString(); // "Hello Java"
System.out.println(result);

}
}