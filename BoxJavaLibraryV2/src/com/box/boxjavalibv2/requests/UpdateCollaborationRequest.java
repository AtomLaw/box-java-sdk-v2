package com.box.boxjavalibv2.requests;

import com.box.boxjavalibv2.IBoxConfig;
import com.box.boxjavalibv2.dao.BoxCollaboration;
import com.box.boxjavalibv2.dao.BoxCollaborationRole;
import com.box.boxjavalibv2.jsonparsing.IBoxJSONParser;
import com.box.boxjavalibv2.requests.requestobjects.BoxCollabRequestObject;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.requestsbase.DefaultBoxRequest;

import org.apache.http.HttpStatus;

/**
 * Request to edit an existing collaboration.
 */
public class UpdateCollaborationRequest extends DefaultBoxRequest {

    public static final String URI = "/collaborations/%s";

    /**
     * Constructor.
     * 
     * @param config
     *            config
     * @param parser
     *            json parser
     * @param id
     *            id of the collaboration
     * @param requestObject
     *            request object
     * @throws BoxRestException
     *             exception
     */
    public UpdateCollaborationRequest(final IBoxConfig config, final IBoxJSONParser parser, String id, BoxCollabRequestObject requestObject)
        throws BoxRestException {
        super(config, parser, getUri(id), RestMethod.PUT, requestObject);
        if (requestObject.getRole().equals(BoxCollaborationRole.OWNER)) {
            setExpectedResponseCode(HttpStatus.SC_NO_CONTENT);
        }
    }

    /**
     * Get uri.
     * 
     * @param id
     *            uri
     * @return
     */
    public static String getUri(final String id) {
        return String.format(URI, id);
    }
}
