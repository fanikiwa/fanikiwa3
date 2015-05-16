package com.sp.fanikiwa.api;

import static com.sp.fanikiwa.api.OfyService.ofy;

import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.AccountDTO;
import com.sp.fanikiwa.entity.Coa;
import com.sp.fanikiwa.entity.Coadet;
import com.sp.fanikiwa.entity.CoadetDTO;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.RequestResult;
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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

@Api(name = "coadetendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class CoadetEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCoadet")
	public CollectionResponse<Coadet> listCoadet(@Named("coaid") Long coaid,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		CoaEndpoint coaendpoint = new CoaEndpoint();
		Coa coa = coaendpoint.getCoaByID(coaid);

		Query<Coadet> query = ofy().load().type(Coadet.class)
				.filter("coa", coa);
		return GetCoadetsFromQuery(query, cursorString, count);
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "selectCoadet")
	public CollectionResponse<Coadet> selectCoadet(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Coadet> query = ofy().load().type(Coadet.class);
		return GetCoadetsFromQuery(query, cursorString, count);
	}

	private CollectionResponse<Coadet> GetCoadetsFromQuery(Query<Coadet> query,
			String cursorString, Integer count) {

		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Coadet> records = new ArrayList<Coadet>();
		QueryResultIterator<Coadet> iterator = query.iterator();
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
		return CollectionResponse.<Coadet> builder().setItems(records)
				.setNextPageToken(cursorString).build();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "retrieveCoadetsDTO")
	public CollectionResponse<CoadetDTO> retrieveCoadetsDTO(
			@Named("coaid") Long coaid,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		CoaEndpoint coaendpoint = new CoaEndpoint();
		Coa coa = coaendpoint.getCoaByID(coaid);

		Query<Coadet> query = ofy().load().type(Coadet.class)
				.filter("coa", coa);
		return SelectCoadetsDTOFromQuery(query, cursorString, count);
	}

	private CollectionResponse<CoadetDTO> SelectCoadetsDTOFromQuery(
			Query<Coadet> query, String cursorString, Integer count) {

		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<CoadetDTO> records = new ArrayList<CoadetDTO>();
		QueryResultIterator<Coadet> iterator = query.iterator();
		int num = 0;
		while (iterator.hasNext()) {
			CoadetDTO dto = createDTOFromCoadet(iterator.next());
			records.add(dto);
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
		return CollectionResponse.<CoadetDTO> builder().setItems(records)
				.setNextPageToken(cursorString).build();
	}

	private Coadet createCoadetFromDTO(CoadetDTO coadetDTO) {
		// Construct dto
		Coadet coadet = new Coadet();
		CoaEndpoint coaendpoint = new CoaEndpoint();
		coadet.setCoa(coaendpoint.getCoaByID(coadetDTO.getCoa()));
		coadet.setCOALevel(coadetDTO.getCOALevel());
		coadet.setDescription(coadetDTO.getDescription());
		coadet.setId(coadetDTO.getId());
		coadet.setRorder(coadetDTO.getRorder());
		coadet.setShortCode(coadetDTO.getShortCode());

		return coadet;
	}

	private CoadetDTO createDTOFromCoadet(Coadet coadet) {
		// Construct dto
		CoadetDTO coadetDTO = new CoadetDTO();
		coadetDTO.setCoa(coadet.getCoa().getId());
		coadetDTO.setCOALevel(coadet.getCOALevel());
		coadetDTO.setDescription(coadet.getDescription());
		coadetDTO.setId(coadet.getId());
		coadetDTO.setRorder(coadet.getRorder());
		coadetDTO.setShortCode(coadet.getShortCode());

		return coadetDTO;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 *
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "selectCoadetByID")
	public Coadet selectCoadetByID(@Named("id") Long id) {
		return findRecord(id);
	}

	@ApiMethod(name = "retrieveCoadet")
	public RequestResult retrieveCoadet(@Named("id") Long id) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Coadet coadet = findRecord(id);
			if (coadet == null) {
				throw new NotFoundException("Record does not exist");
			}
			re.setClientToken(coadet);
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
	 * @param Coadet
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException
	 */
	@ApiMethod(name = "insertCoadet")
	public RequestResult insertCoadet(CoadetDTO coadetDTO) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Coadet coadet = findRecord(coadetDTO.getId());
			if (coadet.getId() != null) {
				if (findRecord(coadet.getId()) != null) {
					throw new ConflictException("Object already exists");
				}
			}
			Coadet insertcoadet = createCoadetFromDTO(coadetDTO);
			ofy().save().entities(insertcoadet).now();
			re.setResultMessage("Chart Of Account Detail Created.<br/>Id = "
					+ coadet.getId());
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
	 * @param Coadet
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "updateCoadet")
	public RequestResult updateCoadet(CoadetDTO coadetDTO) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Coadet coadet = findRecord(coadetDTO.getId());
			if (coadet == null) {
				throw new NotFoundException("Record does not exist");
			}
			Coadet updatecoadet = createCoadetFromDTO(coadetDTO);
			ofy().save().entities(updatecoadet).now();
			re.setResultMessage("Chart Of Account Detail Updated.<br/>Id = "
					+ coadet.getId());
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
	@ApiMethod(name = "removeCoadet")
	public RequestResult removeCoadet(@Named("id") Long id) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Coadet coadet = findRecord(id);
			if (coadet == null) {
				throw new NotFoundException("Record does not exist");
			}
			ofy().delete().entity(coadet).now();
			re.setResultMessage("Chart Of Account Detail Removed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;

	}

	private Coadet findRecord(Long id) {
		return ofy().load().type(Coadet.class).id(id).now();
	}

}
