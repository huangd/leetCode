package leetcode;

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> theIterator;
    Integer topElement = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        theIterator = iterator;
        if (theIterator.hasNext()) topElement = iterator.next();
    }

    public Integer peek() {
        return topElement;
    }

    @Override
    public Integer next() {
        Integer temp = topElement;
        if (theIterator.hasNext()) {
            topElement = theIterator.next();
        } else {
            topElement = null;
        }
        return temp;
    }

    @Override
    public boolean hasNext() {
        return topElement != null;
    }
}
