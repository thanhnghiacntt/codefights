/*
You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it. You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

Return an array where each element is a list with the first element equal to the name of the ingredient and all of the other elements equal to the names of dishes that contain this ingredient. The dishes inside each list should be sorted lexicographically. The result array should be sorted lexicographically by the names of the ingredients in its elements.
*/

String[][] groupingDishes(String[][] dishes) {
    Map<String, List<String>> hash = new HashMap<String, List<String>>();
    for (String[] strings : dishes) {
        String dish = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (hash.containsKey(strings[i])) {
                hash.get(strings[i]).add(dish);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(dish);
                hash.put(strings[i], temp);
            }
        }
    }
    String[][] temp = convertMoreOne(hash);
    sort(temp);
    return temp;
}

void sort(String[][] str) {
    for (int i = 0; i < str.length; i++) {
        for (int j = i + 1; j < str.length; j++) {
            if (compare(str[i][0], str[j][0]) > 0) {
                String[] temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
        }
    }
    for (String[] strings : str) {
        sort(strings);
    }
}

void sort(String[] str) {
    for (int i = 1; i < str.length; i++) {
        for (int j = i + 1; j < str.length; j++) {
            if (compare(str[i], str[j]) > 0) {
                String temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
        }
    }
}

int compare(String first, String second) {
    int i = 0;
    for (; i < first.length() && i < second.length(); i++) {
        if (first.charAt(i) > second.charAt(i)) {
            return 1;
        }
        if (first.charAt(i) < second.charAt(i)) {
            return -1;
        }
    }
    if (i < first.length()) {
        return 1;
    }
    if (i < second.length()) {
        return -1;
    }
    return 0;
}

String[][] convertMoreOne(Map<String, List<String>> hash) {
    List<List<String>> lists = new ArrayList<List<String>>();
    Set<String> keys = hash.keySet();
    for (String string : keys) {
        List<String> list = hash.get(string);
        if (list.size() > 1) {
            list.add(0, string);
            lists.add(list);
        }
    }
    String[][] arrs = new String[lists.size()][];
    for (int i = 0; i < arrs.length; i++) {
        List<String> list = lists.get(i);
        arrs[i] = new String[list.size()];
        for (int j = 0; j < arrs[i].length; j++) {
            arrs[i][j] = list.get(j);
        }
    }
    return arrs;
}