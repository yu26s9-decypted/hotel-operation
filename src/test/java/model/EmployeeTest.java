package model;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void punchTimeCard_isPunchedInCorrectly_EmployeeIsClockedIn(){
        //arrange
        Employee employee = new Employee(1, "Simon", "Engineering", 32.25, 0 );

        //act
        employee.punchTimeCard();

        //assert
        assertTrue(employee.isClockedIn());
    }

    @Test
    public void punchTimeCard_isPunchedInCorrectly_EmployeeAlreadyClockedIn(){
        //arrange

        Employee employee = new Employee(1, "Brandon", "Engineering", 65, 0);
        employee.punchTimeCard();

        //act
        employee.punchTimeCard();

        //assert
        assertFalse(employee.isClockedIn());
    }

    @Test
    public void punchTimeCard_isPunchedOut_CalculateHoursCorrectly() {
        //arrange
        Random random = new Random();
        int randomHour = random.nextInt(1,9);
        int randomEmployeeHourWorked = random.nextInt(0, 50);
        System.out.println(randomHour);
        System.out.println(randomEmployeeHourWorked);

        Employee employee = new Employee(1, "Simon", "Engineering", 65, randomEmployeeHourWorked);
        Instant startDummyTime = Instant.parse("2026-05-05T09:00:00Z");
        Instant endDummytime = startDummyTime.plus(randomHour, ChronoUnit.HOURS);

        //act
        employee.punchTimeCard(startDummyTime, endDummytime);

        //assert
        int expectedTotalHour = randomHour + randomEmployeeHourWorked;
        long actualHourAfterPunchOut = employee.getHoursWorked();
        // 50 hrs, rnd -5, 50-5 = 45  , 5 != 45.
        assertEquals(expectedTotalHour,actualHourAfterPunchOut);
        System.out.printf("%d match %d", expectedTotalHour, actualHourAfterPunchOut);
    }


}