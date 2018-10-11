package com.ilmn.donofero;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static org.junit.Assert.assertThat;

public class ConsecutiveTest {

    //Tests for countMissingInts method

    @Test
    public void test_count_case_one() throws Exception {
        String inputStr = "5, 10, 15";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(8));
    }

    @Test
    public void test_count_case_two() throws Exception {
        String inputStr = "2, 4, 6, 16";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(11));
    }

    @Test
    public void test_count_already_consecutive() throws Exception {
        String inputStr = "2, 3, 4, 5, 6";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(0));
    }

    @Test
    public void test_count_empty_string() throws Exception {
        String inputStr = "";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(0));
    }

    @Test
    public void test_count_out_of_order_input() throws Exception {
        String inputStr = "4, 2, 8, 5, 12";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(6));
    }

    @Test
    public void test_count_with_negative_numbers() throws Exception {
        String inputStr = "2, -4, 13, 8, 9";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(13));
    }

    @Test
    public void test_count_with_positive_sign_prepending_numbers() throws Exception {
        String inputStr = "+2, -4, +13, +8, +9";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(13));
    }

    @Test
    public void test_count_with_duplicates() throws Exception {
        String inputStr = "2, 5, 7, 5, 9, 2";
        // 3, 4, 6, 8 are missing
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(4));
    }

    @Test
    public void test_count_without_spaces() throws Exception {
        String inputStr = "4,2,8,5,12";
        int missingItemCount = Consecutive.countMissingInts(inputStr);
        assertThat(missingItemCount, is(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_count_null_input_throws_exception() throws Exception {
        Consecutive.countMissingInts(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_count_oversized_number_throws_exception() throws Exception {
        long tooBigToBeInt = Integer.MAX_VALUE;
        tooBigToBeInt++;
        String inputStr = "2, 4, 6, 16, " + tooBigToBeInt;
        Consecutive.countMissingInts(inputStr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void non_integer_input_for_count_throws_exception() throws Exception {
        String inputStr = "2, dog, 6, 3.14159";
        Consecutive.countMissingInts(inputStr);
    }







    //Tests for printConsecutiveList method

    @Test
    public void test_print_case_one() throws Exception {
        String inputStr = "5, 10, 15";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is("5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15"));
    }

    @Test
    public void test_print_case_two() throws Exception {
        String inputStr = "2, 4, 6, 16";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is("2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16"));
    }

    @Test
    public void test_print_already_consecutive() throws Exception {
        String inputStr = "2, 3, 4, 5, 6";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is(inputStr));
    }

    @Test
    public void test_print_empty_string() throws Exception {
        String inputStr = "";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList,
                is(emptyString()));
    }

    @Test
    public void test_print_out_of_order_input() throws Exception {
        String inputStr = "4, 2, 8, 5, 12";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is("2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12"));
    }

    @Test
    public void test_print_with_negative_numbers() throws Exception {
        String inputStr = "2, -4, 13, 8, 9";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is("-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13"));
    }

    @Test
    public void test_print_with_positive_sign_prepending_numbers() throws Exception {
        String inputStr = "+2, -4, +13, +8, +9";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is("-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13"));
    }

    @Test
    public void test_print_with_duplicates() throws Exception {
        String inputStr = "2, 5, 7, 5, 9, 2";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is("2, 3, 4, 5, 6, 7, 8, 9"));
    }

    @Test
    public void test_print_without_spaces() throws Exception {
        String inputStr = "4,2,8,5,12";
        String consecutiveList = Consecutive.printConsecutiveList(inputStr);
        assertThat(consecutiveList, is("2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_print_null_input_throws_exception() throws Exception {
        Consecutive.countMissingInts(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void non_integer_input_for_print_throws_exception() throws Exception {
        String inputStr = "2, dog, 6, 3.14159";
        Consecutive.printConsecutiveList(inputStr);
    }

}