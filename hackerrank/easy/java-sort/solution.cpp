                    return 1;
                } else if (s1.getCgpa() > s2.getCgpa()) {
                    return -1;
                }

                // 2. Name: alphabetical order
                int nameCompare =
                    s1.getFname().compareTo(s2.getFname());

                if (nameCompare != 0) {
                    return nameCompare;
                }

                // 3. ID: ascending
                return Integer.compare(s1.getId(), s2.getId());
            }
        });

        for (Student s : students) {
            System.out.println(s.getFname());
        }

        sc.close();
    }
}
