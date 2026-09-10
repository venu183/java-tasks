        for (int i = 0; i < s.length(); i++) {
            char expected;

            if (i % 3 == 0 || i % 3 == 2) {
                expected = 'S';
            } else {
                expected = 'O';
            }

            if (s.charAt(i) != expected) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();

        System.out.println(marsExploration(s));
    }
}