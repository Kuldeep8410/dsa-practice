import java.util.BitSet;
import java.util.Random;
public class BLOOMFILTER {
     private BitSet bitset;
    private int bitsetSize;
    private int numHashFunctions;
    private int seed;

    public BLOOMFILTER(int size, int numHashFunctions) {
        this.bitsetSize = size;
        this.numHashFunctions = numHashFunctions;
        this.bitset = new BitSet(size);
        this.seed = new Random().nextInt(); // random seed
    }

    private int[] getHashes(String item) {
        int[] hashes = new int[numHashFunctions];
        int hash1 = item.hashCode();
        int hash2 = (hash1 >>> 16);

        for (int i = 0; i < numHashFunctions; i++) {
            int combinedHash = hash1 + i * hash2 + seed;
            if (combinedHash < 0) combinedHash = ~combinedHash;
            hashes[i] = combinedHash % bitsetSize;
        }
        return hashes;
    }

    // Insert element
    public void add(String item) {
        int[] hashes = getHashes(item);
        for (int hash : hashes) {
            bitset.set(hash, true);
        }
    }

    // Check membership
    public boolean mightContain(String item) {
        int[] hashes = getHashes(item);
        for (int hash : hashes) {
            if (!bitset.get(hash)) {
                return false; // definitely not present
            }
        }
        return true; // may be present
    }
    public static void main(String[] args) {
        BLOOMFILTER bf = new BLOOMFILTER(1000, 3);

        bf.add("apple");
        bf.add("banana");

        System.out.println(bf.mightContain("apple"));   // true
        System.out.println(bf.mightContain("banana"));  // true
        System.out.println(bf.mightContain("grap"));  // false (definitely not present)
    }
}
