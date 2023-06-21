import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode() {
        this.character = '\0';
        this.frequency = 0;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

class HuffmanEncoder {
    private Map<Character, String> charCodeMap;

    public HuffmanEncoder() {
        charCodeMap = new HashMap<>();
    }

    public void buildCharCodeMap(HuffmanNode root, String code) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            charCodeMap.put(root.character, code);
            return;
        }

        buildCharCodeMap(root.left, code + "0");
        buildCharCodeMap(root.right, code + "1");
    }

    public String encode(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
            priorityQueue.offer(node);
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            priorityQueue.offer(parent);
        }

        HuffmanNode root = priorityQueue.poll();
        buildCharCodeMap(root, "");

        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(charCodeMap.get(c));
        }

        return encodedText.toString();
    }

    public String decode(String encodedText, HuffmanNode root) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode current = root;

        for (int i = 0; i < encodedText.length(); i++) {
            char c = encodedText.charAt(i);

            if (c == '0') {
                current = current.left;
            } else if (c == '1') {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                decodedText.append(current.character);
                current = root;
            }
        }

        return decodedText.toString();
    }
}

public class HuffmanCompression {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String encodedFile = "encoded.bin";
        String decodedFile = "decoded.txt";

        try {
            // Leer el archivo de entrada
            String inputText = readTextFile(inputFile);

            // Codificar el texto
            HuffmanEncoder encoder = new HuffmanEncoder();
            String encodedText = encoder.encode(inputText);

            // Calcular la tasa de compresión
            double compressionRatio = (double) encodedText.length() / (inputText.length() * 8);

            // Guardar el archivo codificado
            saveEncodedFile(encodedFile, encodedText);

            // Decodificar el texto
            HuffmanNode root = new HuffmanNode();
            HuffmanEncoder decoder = new HuffmanEncoder();
            decoder.buildCharCodeMap(root, "");
            String decodedText = decoder.decode(encodedText, root);

            // Guardar el archivo decodificado
            saveTextFile(decodedFile, decodedText);

            // Mostrar mensajes en la consola
            System.out.println("El texto se ha codificado correctamente.");
            System.out.println("Tasa de compresión: " + compressionRatio);
            System.out.println("El texto se ha decodificado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTextFile(String filename) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line);
        }
        reader.close();
        return text.toString();
    }

    public static void saveEncodedFile(String filename, String encodedText) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(encodedText);
        writer.close();
    }

    public static void saveTextFile(String filename, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(text);
        writer.close();
    }
}
