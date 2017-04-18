package io.weirdguy.practice.huffman;


public class Tester {
    public static void main(String[] args) {
        String text = "iirtyedcbwertebfdter;sdgwer qwetqwddrw e";

        int[] charFrequencies = new int[256];

        for (char c : text.toCharArray()) {
            charFrequencies[c]++;
        }

        HuffmanTree tree = HuffmanTree.buildHuffmanTree(charFrequencies);
        log("size before compression = " + text.length() * 8);
        String incoded = tree.incode(text);
        log("incoded result = " + incoded);
        log("size after compression = " + incoded.length());
        String decoded = tree.decode(incoded);
        log(decoded);

        tree.printCodes();
    }

    private static void log(Object obj) {
        System.out.println(obj);
    }
}