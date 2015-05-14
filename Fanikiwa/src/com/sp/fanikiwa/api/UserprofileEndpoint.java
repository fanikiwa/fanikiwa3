package com.sp.fanikiwa.api;

import static com.sp.fanikiwa.api.OfyService.ofy;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.google.gson.JsonPrimitive;
import com.googlecode.objectify.cmd.Query;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.RequestResult;
import com.sp.fanikiwa.entity.Settings;
import com.sp.fanikiwa.entity.Userprofile;
import com.sp.utils.DateExtension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

@Api(name = "userprofileendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class UserprofileEndpoint {

	public UserprofileEndpoint() {

	}

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listUserprofile")
	public CollectionResponse<Userprofile> listUserprofile(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Userprofile> query = ofy().load().type(Userprofile.class);
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Userprofile> records = new ArrayList<Userprofile>();
		QueryResultIterator<Userprofile> iterator = query.iterator();
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
		return CollectionResponse.<Userprofile> builder().setItems(records)
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
	@ApiMethod(name = "getUserprofileByUserID")
	public Userprofile getUserprofileByUserID(@Named("id") String id) {
		return findRecord(id);
	}

	@ApiMethod(name = "retrieveUser")
	public RequestResult retrieveUser(@Named("id") String id) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Userprofile user = findRecord(id);
			if (user == null) {
				throw new NotFoundException("Record does not exist");
			}
			re.setClientToken(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param Userprofile
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "updateUserprofile")
	public RequestResult updateUserprofile(Userprofile Userprofile) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Userprofile user = findRecord(Userprofile.getUserId());
			if (user == null) {
				throw new NotFoundException("Record does not exist");
			}
			ofy().save().entities(Userprofile).now();
			re.setResultMessage("User Updated.<br/>Id = " + user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "removeUserprofile")
	public RequestResult removeUserprofile(@Named("id") String id) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Userprofile user = findRecord(id);
			if (user == null) {
				throw new NotFoundException("Record does not exist");
			}
			ofy().delete().entity(user).now();
			re.setResultMessage("Setting Removed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;

	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param Userprofile
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException
	 */
	@ApiMethod(name = "insertUserprofile")
	public RequestResult insertUserprofile(Userprofile userprofile) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			if (userprofile.getUserId() != null) {
				if (findRecord(userprofile.getUserId()) != null) {
					throw new ConflictException("Object already exists");
				}
			}
			ofy().save().entities(userprofile).now();
			re.setResultMessage("User Created.<br/>Id = "
					+ userprofile.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	@ApiMethod(name = "changePassword")
	public RequestResult changePassword(@Named("userId") String userId,
			@Named("pwd") String pwd) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Userprofile user = null;
			user = findRecord(userId);
			user.setPwd(pwd);

			updateUserprofile(user);
			re.setResultMessage("Password Changed...");
		} catch (Exception e) {
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	@ApiMethod(name = "login")
	public RequestResult Login(@Named("userId") String userId,
			@Named("pwd") String pwd) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");

		Userprofile user = null;
		user = findRecord(userId);
		if (user == null) {
			re.setResult(false);
			re.setResultMessage("User with email [ " + userId
					+ " ] does not exist!");
			return re;
		}
		if (AuthenticateUser(user, pwd)) {
			re.setResult(true);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			re.setResultMessage("created date:"
					+ sdf.format(user.getCreateDate()));
			re.setClientToken(user);
			return re;
		} else {
			re.setResult(false);
			re.setResultMessage("User Exists but Password is incorrect.");
		}
		return re;
	}

	public RequestResult UserExists(@Named("userId") String userId) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");

		Userprofile user = null;
		user = findRecord(userId);
		if (user == null) {
			re.setResult(false);
			re.setResultMessage("User with email [ " + userId
					+ " ] does not exist!");
			return re;
		}
		re.setClientToken(user);
		return re;
	}

	private boolean AuthenticateUser(Userprofile user, String pwd) {
		if (user != null) {
			if (user.getPwd().equals(pwd)) {
				return true;
			}
		}
		return false;
	}

	private Userprofile findRecord(String id) {
		return ofy().load().type(Userprofile.class).id(id).now();
	}

	public Userprofile LoginByPhone(@Named("telephone") String telephone,
			@Named("pwd") String pwd) {
		// TODO Auto-generated method stub
		Userprofile user = ofy().load().type(Userprofile.class)
				.filter("telephone", telephone).first().now();

		if (AuthenticateUser(user, pwd)) {
			return user;
		} else
			return null;
	}

}
