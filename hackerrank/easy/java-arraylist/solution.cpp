            arr.add(list);
        }

        // Number of queries
        int q = sc.nextInt();

        // Process queries
        for (int i = 0; i < q; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            // x and y are 1-based
            if (x >= 1 && x <= arr.size()
                    && y >= 1 && y <= arr.get(x - 1).size()) {

                System.out.println(arr.get(x - 1).get(y - 1));

            } else {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}