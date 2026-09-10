
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }

            sum += z[i];
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            System.out.println(stringSimilarity(s));
        }
    }
}
