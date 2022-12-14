package io.github.ungle.kong.client.api.plugins;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.ungle.kong.client.model.ApiDataList;
import io.github.ungle.kong.client.requests.plugins.AclRequest;
import io.github.ungle.kong.client.response.ConsumerResponse;
import io.github.ungle.kong.client.response.plugins.AclResponse;

/**
 * 
 * @author ungle
 *
 */
public interface AclApi {

	/**
	 * Create an ACL group name by passing a new group name
	 * 
	 * @param consumer   The username or id property of the consumer entity to
	 *                   associate the credentials with
	 * @param aclRequest group info
	 * @return added acl
	 */
	@RequestLine("POST /consumers/{consumer}/acls")
	@Headers("Content-Type: application/json")
	AclResponse add(@Param("consumer") String consumer, AclRequest aclRequest);

	/**
	 * get all acl list
	 * 
	 * @return acl list
	 */
	@RequestLine("GET /acls")
	ApiDataList<AclResponse> find();

	/**
	 * get acls by offset
	 * 
	 * @param offset offset
	 * @return acl list
	 */
	@RequestLine("GET /acls?offset={offset}")
	ApiDataList<AclResponse> findByOffset(@Param("offset") String offset);

	/**
	 * Retrieve ACLs by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @return acl list
	 */
	@RequestLine("GET /consumers/{consumer}/acls")
	ApiDataList<AclResponse> findByConsumer(@Param("consumer") String consumer);

	/**
	 * Retrieve ACLs by consumer
	 * 
	 * @param consumer The username or id of the consumer
	 * @param offset offset
	 * @return acl list
	 */
	@RequestLine("GET /consumers/{consumer}/acls?offset={offset}")
	ApiDataList<AclResponse> findByConsumerAndOffset(@Param("consumer") String consumer,
			@Param("offset") String offset);

	/**
	 * Retrieve ACL by ID
	 * 
	 * @param consumer The username or id property of the consumer entity
	 * @param aclId    The id property of the ACL
	 * @return acl info
	 */
	@RequestLine("GET /consumers/{consumer}/acls/{id}")
	AclResponse retrieve(@Param("consumer") String consumer, @Param("id") String aclId);

	/**
	 * Retrieve the consumer associated with an ACL
	 * 
	 * @param aclId The id property of the ACL
	 * @return consumer info
	 */
	@RequestLine("GET /acls/{id}/consumer")
	ConsumerResponse retrieveConsumerWithAcl(@Param("id") String aclId);

	/**
	 * Update and insert an ACL group name
	 * 
	 * @param consumer   The username or id property of the consumer entity
	 * @param aclId      The id property of the ACL
	 * @param aclRequest acl info
	 * @return added acl info
	 */
	@RequestLine("PUT /consumers/{consumer}/acls/{id}")
	@Headers("Content-Type: application/json")
	AclResponse add(@Param("consumer") String consumer, @Param("id") String aclId, AclRequest aclRequest);

	/**
	 * Deletes an ACL group by ID
	 * 
	 * @param consumer The username or id property of the consumer entity.
	 * @param aclId    The id property of the ACL
	 */
	@RequestLine("DELETE /consumers/{consumer}/acls/{id}")
	void delete(@Param("consumer") String consumer, @Param("id") String aclId);

	/**
	 * Deletes an ACL group by group name
	 * 
	 * @param consumer The username or id property of the consumer entity
	 * @param group    The group property of the ACL
	 */
	@RequestLine("DELETE /consumers/{consumer}/acls/{group}")
	void deleteByGroup(@Param("consumer") String consumer, @Param("group") String group);

}
