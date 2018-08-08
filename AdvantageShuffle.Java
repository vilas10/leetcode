/*
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.
*/
class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        // A = [12,24,8,32], B =  [13,25,32,11]
        // Acopy 8,12,24,32  Bcopy 11,13,35,39
        int[] Acopy = new int[A.length];
        int[] Bcopy = new int[B.length];
        Acopy = Arrays.copyOf(A, A.length);
        Bcopy = Arrays.copyOf(B, B.length);
        Arrays.sort(Acopy);
        Arrays.sort(Bcopy);
        
        HashMap<Integer, List<Integer>> mapB = new HashMap<>();
        
        for (int i = 0; i < B.length; i++) {
            if (mapB.containsKey(B[i])) {
                List<Integer> list = mapB.get(B[i]);
                list.add(i);
                mapB.put(B[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapB.put(B[i], list);
            }
        }
        
        int i = 0;
        int j = 0;
        int last = A.length - 1;
        while (i < A.length && j < B.length) {
            int index = j;
            if (Acopy[i] <= Bcopy[j]) {
                index = last--;
            } else {
                index = j++;
            }
            List<Integer> list = (ArrayList<Integer>) mapB.get(Bcopy[index]);
            A[list.get(0)] = Acopy[i++];
            list.remove(0);
            
            if (list.isEmpty()) {
                mapB.remove(Bcopy[index]);
            } else {
                mapB.put(Bcopy[index], list);
            }
        }
        
        return A;
    }
}
