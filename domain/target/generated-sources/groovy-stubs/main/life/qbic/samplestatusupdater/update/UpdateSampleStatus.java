package life.qbic.samplestatusupdater.update;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

public interface UpdateSampleStatus
 {
;
 java.lang.Object update(java.lang.String sampleCode, life.qbic.datamodel.services.Location location, life.qbic.datamodel.services.Status status)throws life.qbic.samplestatusupdater.update.SampleUpdateException;
}
