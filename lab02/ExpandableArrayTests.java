public class ExpandableArrayTests {

  public static void main(String[] args) {
    ExpandableArray<Integer> fancyArray = new ExpandableArray<Integer>(2);
    //fancyArray.insert(0, 10);
    for (int i = 0; i <= 100; i++) {
      fancyArray.insert(i);
      assert fancyArray.get(0) == i;
      assert fancyArray.get(fancyArray.size()-1) == 0;
    }
    assert fancyArray.remove(0) == 100;


    ExpandableArray<Integer> fancyArray1 = new ExpandableArray<Integer>(5);
    assert fancyArray1.toString().equals("");

    fancyArray1.insert(0);
    fancyArray1.insert(0);
    fancyArray1.insert(0);
    fancyArray1.insert(3,3);
    assert fancyArray1.toString().equals("0, 0, 0, 3");

    fancyArray1.insert(5,4);
    assert fancyArray1.toString().equals("0, 0, 0, 3, 5");

    fancyArray1.remove(3);
    assert fancyArray1.toString().equals("0, 0, 0, 5");
    assert fancyArray1.size() == 4;

    fancyArray1.set(10, 0);
    assert fancyArray1.toString().equals("10, 0, 0, 5");

    ExpandableArray<String> fancyArrayStr = new ExpandableArray<String>(1000);
    //fancyArray.insert(0, 10);
    for (int i = 0; i <= 100; i++) {
      fancyArrayStr.insert(i+"");
      assert fancyArrayStr.get(0).equals(i + "");
      assert fancyArrayStr.get(fancyArrayStr.size()-1).equals("0");
    }
    assert fancyArrayStr.remove(0).equals("100");

    

  }

}
