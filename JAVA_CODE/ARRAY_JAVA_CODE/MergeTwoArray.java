public static int[] merge(int[] arr1, int[] arr2) {

    int arr1Length = arr1.length;
    int arr2Length = arr2.length;

    int[] merged = new int[arr1Length + arr2Length];

    int arr1Position, arr2Position, mergedPosition;
    arr1Position = arr2Position = mergedPosition = 0;

    while(arr1Position < arr1Length && arr2Position < arr2Length) {
        if (arr1[arr1Position] < arr2[arr2Position]) {
            merged[mergedPosition++] = arr1[arr1Position++];
        } else {
            merged[mergedPosition++] = arr2[arr2Position++];
        }
    }

    while (arr1Position < arr1Length) {
        merged[mergedPosition++] = arr1[arr1Position++];
    }

    while (arr2Position < arr2Length) {
        merged[mergedPosition++] = arr2[arr2Position++];
    }

    return merged;
}

public void givenTwoSortedArrays_whenMerged_thenReturnMergedSortedArray() {

    int[] foo = { 3, 7 };
    int[] bar = { 4, 8, 11 };
    outputint[] merged = { 3, 4, 7, 8, 11 };

    assertArrayEquals(merged, SortedArrays.merge(foo, bar));
}