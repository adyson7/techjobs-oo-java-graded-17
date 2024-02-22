package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //Job object created using the full constructor and filler data
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

      //assertTrue(job instanceof Job);
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        //checking to make sure these are instances of the class
    }

    //assertTrue and assertEquals statements used to verify that the constructor correctly assigns both the class and value of each field
    @Test
    public void testJobsForEquality() {
        //created two job objects, identical other than the id field
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    //assertFalse method to verify that the equals method returns false for these two objects
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();
        assertTrue(jobString.startsWith("\n"));
        assertTrue(jobString.endsWith("\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job1.toString();
        assertTrue(jobString.contains("ID: " + job1.getId()));
        assertTrue(jobString.contains("Name:Product tester"));
        assertTrue(jobString.contains("Employer:ACME"));
        assertTrue(jobString.contains("Location:Desert"));
        assertTrue(jobString.contains("Position Type:Quality control"));
        assertTrue(jobString.contains("Core Competency:Persistence"));
    }
//    @Test
//    public void testToStringContainsCorrectLabelsAndData() {
//        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        String expected = "ID: 1\n" +
//                "Name: Product tester\n" +
//                "Employer: ACME\n" +
//                "Location: Desert\n" +
//                "Position Type: Quality control\n" +
//                "Core Competency: Persistence\n";
//        String jobString = job1.toString();
//        assertEquals(expected, jobString);
//    }


    @Test
    public void testToStringHandlesEmptyField()  {
        Job job2 = new Job("", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newLine = System.lineSeparator();
        assertEquals(newLine +
                "ID: " + job2.getId() + newLine +
                "Name: Data not available" + newLine +
                "Employer: Data not available" + newLine +
                "Location: " + job2.getLocation() + newLine +
                "Position Type: " + job2.getPositionType() + newLine +
                "Core Competency: " + job2.getCoreCompetency() + newLine, job2.toString());
    }
}
