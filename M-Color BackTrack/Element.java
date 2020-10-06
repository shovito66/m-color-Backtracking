class Element implements Comparable<Element> {

    int index, value;

    Element(int index, int value){
        this.index = index;  //vertex
        this.value = value;  //degree
    }

    public int compareTo(Element e) {
        return this.value - e.value;
    }
}