/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

*/

class MinStack {
    
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minstack = new ArrayList<Integer>();
    int sTop = -1;
    int msTop = -1;
    
    public void push(int x) {
        stack.add(x);
        if(msTop == -1) {
            minstack.add(x);
            msTop++;
        } else {
            if(minstack.get(msTop) >= x) {
                minstack.add(x);
                msTop++;
            }
        }
        
        sTop++;
    }

    public void pop() {
        if(sTop > -1){
            if(stack.get(sTop).intValue() == minstack.get(msTop).intValue()) {
            minstack.remove(msTop);
            msTop--;
        }
            stack.remove(sTop);
            sTop--;
        }
    }

    public int top() {
        return stack.get(sTop);
    }

    public int getMin() {
        return minstack.get(msTop);
    }
}
