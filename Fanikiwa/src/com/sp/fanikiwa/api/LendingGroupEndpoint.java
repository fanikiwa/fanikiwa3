package com.sp.fanikiwa.api;

import static com.sp.fanikiwa.api.OfyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

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


import com.sp.fanikiwa.entity.Lendinggroup;
import com.sp.fanikiwa.entity.Member;

public class LendingGroupEndpoint {
	@Api(name = "lendinggroupendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
	public class LendinggroupEndpoint {

		public LendinggroupEndpoint() {

		}

		/**
		 * This method lists all the entities inserted in datastore. It uses HTTP
		 * GET method and paging support.
		 *
		 * @return A CollectionResponse class containing the list of all entities
		 *         persisted and a cursor to the next page.
		 */
		@SuppressWarnings({ "unchecked", "unused" })
		@ApiMethod(name = "listLendinggroup")
		public CollectionResponse<Lendinggroup> listLendinggroup(
				@Nullable @Named("cursor") String cursorString,
				@Nullable @Named("count") Integer count) {

			Query<Lendinggroup> query = ofy().load().type(Lendinggroup.class);
			return GetLendinggroupsFromQuery(query, cursorString, count);
		}
		
		@ApiMethod(name = "retrieveLendinggroupsByCreator")
		public CollectionResponse<Lendinggroup> retrieveLendinggroupsByCreator(
				@Named("email") String email,
				@Nullable @Named("cursor") String cursorString,
				@Nullable @Named("count") Integer count) {

			MemberEndpoint mep = new MemberEndpoint();
			Member member = mep.GetMemberByEmail(email);
			return selectLendinggroupsByCreator(member.getMemberId(), cursorString, count);
		}

		@ApiMethod(name = "selectLendinggroupsByCreator")
		public CollectionResponse<Lendinggroup> selectLendinggroupsByCreator(
				@Named("memberid") long MemberId,
				@Nullable @Named("cursor") String cursorString,
				@Nullable @Named("count") Integer count) {

			Member member = ofy().load().type(Member.class).id(MemberId).now();
			Query<Lendinggroup> query = ofy().load().type(Lendinggroup.class)
					.filter("creator", member);
			return GetLendinggroupsFromQuery(query, cursorString, count);
		}

		private CollectionResponse<Lendinggroup> GetLendinggroupsFromQuery(Query<Lendinggroup> query,
				String cursorString, Integer count) {

			if (count != null)
				query.limit(count);
			if (cursorString != null && cursorString != "") {
				query = query.startAt(Cursor.fromWebSafeString(cursorString));
			}

			List<Lendinggroup> records = new ArrayList<Lendinggroup>();
			QueryResultIterator<Lendinggroup> iterator = query.iterator();
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
			return CollectionResponse.<Lendinggroup> builder().setItems(records)
					.setNextPageToken(cursorString).build();
		}

		 

		/**
		 * This method gets the entity having primary key id. It uses HTTP GET
		 * method.
		 *
		 * @param id
		 *            the primary key of the java bean.
		 * @return The entity with primary key id.
		 */
		@ApiMethod(name = "getLendinggroupByID")
		public Lendinggroup getLendinggroupByID(@Named("groupId") String id) {
			return findRecord(id);
		}

		/**
		 * This method is used for updating an existing entity. If the entity does
		 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
		 * method.
		 *
		 * @param Lendinggroup
		 *            the entity to be updated.
		 * @return The updated entity.
		 * @throws NotFoundException
		 */
		@ApiMethod(name = "updateLendinggroup")
		public Lendinggroup updateLendinggroup(Lendinggroup Lendinggroup) throws NotFoundException {
			Lendinggroup record = findRecord(Lendinggroup.getGroupName());
			if (record == null) {
				throw new NotFoundException("Record does not exist");
			}
			ofy().save().entities(Lendinggroup).now();
			return Lendinggroup;
		}

		/**
		 * This method removes the entity with primary key id. It uses HTTP DELETE
		 * method.
		 *
		 * @param id
		 *            the primary key of the entity to be deleted.
		 * @throws NotFoundException
		 */
		@ApiMethod(name = "removeLendinggroup")
		public void removeLendinggroup(@Named("id") String id) throws NotFoundException {
			Lendinggroup record = findRecord(id);
			if (record == null) {
				throw new NotFoundException("Record does not exist");
			}
			ofy().delete().entity(record).now();
		}

		private Lendinggroup findRecord(String id) {
			return ofy().load().type(Lendinggroup.class).id(id).now();
		}

		/**
		 * This inserts a new entity into App Engine datastore. If the entity
		 * already exists in the datastore, an exception is thrown. It uses HTTP
		 * POST method.
		 *
		 * @param Lendinggroup
		 *            the entity to be inserted.
		 * @return The inserted entity.
		 * @throws ConflictException
		 */
		//@ApiMethod(name = "insertLendinggroup")
		public Lendinggroup insertLendinggroup(Lendinggroup Lendinggroup) throws NotFoundException,
				ConflictException {
			if (Lendinggroup.getGroupName() != null) {
				if (findRecord(Lendinggroup.getGroupName()) != null) {
					throw new ConflictException("Object already exists");
				}
			}
			ofy().save().entities(Lendinggroup).now();
			return Lendinggroup;
		}

	}
}