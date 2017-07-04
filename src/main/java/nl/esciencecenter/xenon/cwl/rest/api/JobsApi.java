package nl.esciencecenter.xenon.cwl.rest.api;

import nl.esciencecenter.xenon.cwl.rest.model.Job;
import nl.esciencecenter.xenon.cwl.rest.model.JobDescription;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;

@Api(value = "jobs", description = "the jobs API")
public interface JobsApi {

    @ApiOperation(value = "Cancel a job", notes = "", response = Job.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Job has been cancelled if job was still running or waiting", response = Job.class),
        @ApiResponse(code = 404, message = "Job not found", response = Job.class) })
    @RequestMapping(value = "/jobs/{jobId}/cancel",
        method = RequestMethod.POST)
    default ResponseEntity<Job> cancelJobById(@ApiParam(value = "Job ID",required=true ) @PathVariable("jobId") String jobId) {
        // do some magic!
        return new ResponseEntity<Job>(HttpStatus.OK);
    }


    @ApiOperation(value = "Deleta a job", notes = "Delete a job, if job is in waiting or running state then job will be cancelled first.", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Job deleted", response = Void.class),
        @ApiResponse(code = 404, message = "Job not found", response = Void.class) })
    @RequestMapping(value = "/jobs/{jobId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteJobById(@ApiParam(value = "Job ID",required=true ) @PathVariable("jobId") String jobId) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @ApiOperation(value = "Get a job", notes = "", response = Job.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status of job", response = Job.class),
        @ApiResponse(code = 404, message = "Job not found", response = Job.class) })
    @RequestMapping(value = "/jobs/{jobId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Job> getJobById(@ApiParam(value = "Job ID",required=true ) @PathVariable("jobId") String jobId) {
        // do some magic!
        return new ResponseEntity<Job>(HttpStatus.OK);
    }


    @ApiOperation(value = "Log of a job", notes = "", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Job log", response = String.class),
        @ApiResponse(code = 302, message = "Job log redirect", response = String.class),
        @ApiResponse(code = 404, message = "Job not found", response = String.class) })
    @RequestMapping(value = "/jobs/{jobId}/log",
        produces = { "text/plain" }, 
        method = RequestMethod.GET)
    default ResponseEntity<String> getJobLogById(@ApiParam(value = "Job ID",required=true ) @PathVariable("jobId") String jobId) {
        // do some magic!
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @ApiOperation(value = "list of jobs", notes = "get a list of all jobs, running, cancelled, or otherwise.", response = Job.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "list of jobs", response = Job.class) })
    @RequestMapping(value = "/jobs",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Job>> getJobs() {
        // do some magic!
        return new ResponseEntity<List<Job>>(HttpStatus.OK);
    }


    @ApiOperation(value = "submit a new job", notes = "Submit a new job from a workflow definition.", response = Job.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "OK", response = Job.class) })
    @RequestMapping(value = "/jobs",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Job> postJob(@ApiParam(value = "Input binding for workflow." ,required=true ) @RequestBody JobDescription body) {
        // do some magic!
        return new ResponseEntity<Job>(HttpStatus.OK);
    }

}
