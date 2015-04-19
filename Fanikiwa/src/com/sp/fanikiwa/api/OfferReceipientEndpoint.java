package com.sp.fanikiwa.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.cmd.Query;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.OfferReceipient;

import static com.sp.fanikiwa.api.OfyService.ofy;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;


@Api(name = "offerreceipientendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class OfferReceipientEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */  
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listOfferReceipient")
	public CollectionResponse<OfferReceipient> listOfferReceipient(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<OfferReceipient> query = ofy().load().type(OfferReceipient.class);
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<OfferReceipient> records = new ArrayList<OfferReceipient>();
		QueryResultIterator<OfferReceipient> iterator = query.iterator();
		int num = 0;
		while (iterator.hasNext()) {
			records.add(iterator.next());
			if (count != null) {
				num++;
				if (num == count)
					break;
			}
		}

		// Find the next cursor
		if (cursorString != null && cursorString != "") {
			Cursor cursor = iterator.getCursor();
			if (cursor != null) {
				cursorString = cursor.toWebSafeString();
			}
		}
		return CollectionResponse.<OfferReceipient> builder().setItems(records)
				.setNextPageToken(cursorString).build();
	}
	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getOfferReceipient")
	public OfferReceipient getOfferReceipient(@Named("id") Long id) {
		return findRecord(id);
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param OfferReceipient the entity to be inserted.
	 * @return The inserted entity.
	 */

	@ApiMethod(name = "insertOfferReceipient")
	public OfferReceipient insertOfferReceipient(OfferReceipient OfferReceipient) throws ConflictException {
		// If if is not null, then check if it exists. If yes, throw an
		// Exception
		// that it is already present
		if (OfferReceipient.getOfferReceipientId() != null) {
			if (findRecord(OfferReceipient.getOfferReceipientId()) != null) {
				throw new ConflictException("Object already exists");
			}
		}
		// Since our @Id field is a Long, Objectify will generate a unique value
		// for us
		// when we use put
		ofy().save().entity(OfferReceipient).now();
		return OfferReceipient;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param OfferReceipient the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateOfferReceipient")
	public OfferReceipient updateOfferReceipient(OfferReceipient OfferReceipient) throws NotFoundException {
		if (findRecord(OfferReceipient.getOfferReceipientId()) == null) {
			throw new NotFoundException("Quote Record does not exist");
		}
		ofy().save().entity(OfferReceipient).now();
		return OfferReceipient;
	}


	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeOfferReceipient")
	public void removeOfferReceipient(@Named("id") Long id) throws NotFoundException {
		OfferReceipient record = findRecord(id);
		if (record == null) {
			throw new NotFoundException("Quote Record does not exist");
		}
		ofy().delete().entity(record).now();
	}

	
	// Private method to retrieve a <code>Quote</code> record
	private OfferReceipient findRecord(Long id) {
		return ofy().load().type(OfferReceipient.class).id(id).now();
	}
	@ApiMethod(name = "isOfferAvaiable")
	public OfferReceipient isOfferAvaiable(OfferReceipient or) {
		// TODO Auto-generated method stub
		return ofy().load().type(OfferReceipient.class)
				.filter("member", or.getMember())
				.filter("offer", or.getMember())
				.first()
				.now();
	
	}

}