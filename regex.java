import java.util.regex.*;
public class regex {
    public static void main(String[] args) {
        String text = "You are my lovely love you are my heart you are a sunshine Cat";
        
        // 1. Compile regex into a Pattern
        Pattern pattern = Pattern.compile("^.a.*"); 
        // Here: ^.a.* → any string with 'a' as the 2nd letter

        // 2. Create a Matcher for a specific string
        Matcher matcher1 = pattern.matcher("Cat");
        Matcher matcher2 = pattern.matcher("heart");

        // 3. matches() → check if ENTIRE string fits pattern
        System.out.println("Cat matches? " + matcher1.matches()); // true
        System.out.println("heart matches? " + matcher2.matches()); // false

        // New pattern to search inside longer text
        Pattern searchPattern = Pattern.compile("\\b[aA]..\\b"); 
        // \b → word boundary, [aA] → starts with 'a' or 'A', .. → any 2 chars

        Matcher matcher = searchPattern.matcher(text);

        // 4. find() → check if any substring matches
        while(matcher.find()) {
            System.out.println("Found: " + matcher.group());  // matched substring
            System.out.println("Starts at index: " + matcher.start());
            System.out.println("Ends at index: " + matcher.end());
        }

        // 5. replaceAll() → replace matches
        String replaced = text.replaceAll("\\bCat\\b", "Tigeress");
        System.out.println("After replace: " + replaced);

        // 6. split() → split string by regex
        String[] parts = text.split("\\s+"); // split by spaces
        System.out.println("Split words: ");
        for(String word : parts) {
            System.out.println(word);
        }
    }
}
