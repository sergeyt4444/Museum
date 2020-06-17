package Items;

import Client.Client;

import java.util.ArrayList;

public class NShortItems {

    public static int N = 10;
    public int size;
    public int[] numbers;
    public ArrayList<String> names;
    public ArrayList<String> types;
    public int number_of_objects;

    public NShortItems() {
        numbers = new int[N];
        names = new ArrayList<String>(N);
        types = new ArrayList<String>(N);
        number_of_objects = 0;
    }

    public NShortItems(ArrayList<Item> items, int num, int obj_num) {
        numbers = new int[N];
        names = new ArrayList<String>(N);
        types = new ArrayList<String>(N);
        number_of_objects = obj_num;
        if (num >= 0) {
            size = 0;
            for (int i = 0; i < N; i++) {
                if (num + i >= number_of_objects || items.get(num + i) == null) {
                    break;
                }
                size++;
                numbers[i] = num + i;
                names.add(items.get(num + i).getName());
                types.add(items.get(num + i).getType());
            }
        }
    }

    public NShortItems(ArrayList<Item> items, int num) {
        numbers = new int[N];
        names = new ArrayList<String>(N);
        types = new ArrayList<String>(N);
        if (num >= 0) {
            size = 0;
            for (int i = 0; i < N; i++) {
                if (num + i >= number_of_objects || items.get(num + i) == null) {
                    break;
                }
                size++;
                numbers[i] = num + i;
                names.add(items.get(num + i).getName());
                types.add(items.get(num + i).getType());
            }
        }
    }

    public void Init(ArrayList<Item> items, int num, int obj_num) {
        if (num >= 0) {
            number_of_objects = obj_num;
            size = 0;
            names.clear();
            types.clear();
            for (int i = 0; i < N; i++) {
                if (num + i >= number_of_objects || items.get(num + i) == null) {
                    break;
                }
                size++;
                numbers[i] = num + i;
                names.add(items.get(num + i).getName());
                types.add(items.get(num + i).getType());
            }
        }
    }

//    public void Init2(ArrayList<FullItem> items, int num, int obj_num) {
//        if (num >= 0) {
//            number_of_objects = obj_num;
//            size = 0;
//            names.clear();
//            types.clear();
//            for (int i = 0; i < N; i++) {
//                if (items.get(num + i) == null) {
//                    break;
//                }
//                size++;
//                numbers[i] = num + i;
//                names.add(items.get(num + i).Name);
//                types.add(items.get(num + i).Type);
//            }
//        }
//    }
}
