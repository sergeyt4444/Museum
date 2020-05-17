package Items;

import java.util.ArrayList;

public class NShortItems {

    public static int N = 10;
    public int size;
    public int[] numbers;
    public ArrayList<String> names;
    public ArrayList<String> types;

    public NShortItems() {
        numbers = new int[N];
        names = new ArrayList<String>(N);
        types = new ArrayList<String>(N);
    }

    public NShortItems(ArrayList<Item> items, int num) {
        numbers = new int[N];
        names = new ArrayList<String>(N);
        types = new ArrayList<String>(N);
        if (num >= 0) {
            size = 0;
            for (int i = 0; i < N; i++) {
                if (items.get(num + i) == null) {
                    break;
                }
                size++;
                numbers[i] = num + i;
                names.add(items.get(num + i).getName());
                types.add(items.get(num + i).getType());
            }
        }
    }

    public void Init(ArrayList<Item> items, int num) {
        if (num >= 0) {
            size = 0;
            names.clear();
            types.clear();
            for (int i = 0; i < N; i++) {
                if (items.get(num + i) == null) {
                    break;
                }
                size++;
                numbers[i] = num + i;
                names.add(items.get(num + i).getName());
                types.add(items.get(num + i).getType());
            }
        }
    }

    public void Init2(ArrayList<FullItem> items, int num) {
        if (num >= 0) {
            size = 0;
            names.clear();
            types.clear();
            for (int i = 0; i < N; i++) {
                if (items.get(num + i) == null) {
                    break;
                }
                size++;
                numbers[i] = num + i;
                names.add(items.get(num + i).Name);
                types.add(items.get(num + i).Type);
            }
        }
    }
}
