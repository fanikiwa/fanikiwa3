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

import static com.sp.fanikiwa.api.OfyService.ofy;

import com.sp.fanikiwa.entity.Customer;
import com.sp.fanikiwa.entity.CustomerDTO;
import com.sp.fanikiwa.entity.RequestResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

@Api(name = "customerendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class CustomerEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCustomer")
	public CollectionResponse<Customer> listCustomer(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Customer> query = ofy().load().type(Customer.class);
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Customer> records = new ArrayList<Customer>();
		QueryResultIterator<Customer> iterator = query.iterator();
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
		return CollectionResponse.<Customer> builder().setItems(records)
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
	@ApiMethod(name = "getCustomer")
	public Customer getCustomer(@Named("id") Long id) {
		return findRecord(id);
	}

	@ApiMethod(name = "retrieveCustomer")
	public RequestResult retrieveCustomer(@Named("id") Long id) {
		RequestResult re = new RequestResult();
		re.setSuccess(false);
		re.setResultMessage("Not Successful");
		try {
			Customer customer = findRecord(id);
			if (customer == null) {
				throw new NotFoundException("Customer " + id
						+ " does not exist");
			}
			CustomerDTO customerDTO = createDTOFromCustomer(customer);
			re.setClientToken(customerDTO);
			re.setResultMessage("Successful");
			re.setSuccess(true);
			return re;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re.setSuccess(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param customer
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException
	 */
	@ApiMethod(name = "insertCustomer")
	public Customer insertCustomer(Customer customer) throws NotFoundException,
			ConflictException {
		if (customer.getCustomerId() != null) {
			if (findRecord(customer.getCustomerId()) != null) {
				throw new ConflictException("Customer "
						+ customer.getCustomerId() + "already exists");
			}
		}
		ofy().save().entities(customer).now();
		return customer;
	}

	@ApiMethod(name = "createCustomer")
	public RequestResult createCustomer(CustomerDTO customerDTO) {
		RequestResult re = new RequestResult();
		re.setSuccess(false);
		re.setResultMessage("Not Successful");

		try {
			Customer customerFromDTO = createCustomerFromDTO(customerDTO);
			Customer insertedcustomer = this.insertCustomer(customerFromDTO);
			if (insertedcustomer.getCustomerId() == null) {
				re.setSuccess(false);
				re.setResultMessage("Error Creating Customer.");
				return re;
			}
			re.setResultMessage("Customer Created.<br/>Id = "
					+ insertedcustomer.getCustomerId());
			re.setSuccess(true);
			return re;
		} catch (Exception e) {
			e.printStackTrace();
			re.setSuccess(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param customer
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "updateCustomer")
	public Customer updateCustomer(Customer customer) throws NotFoundException {
		Customer record = findRecord(customer.getCustomerId());
		if (record == null) {
			throw new NotFoundException("Customer " + customer.getCustomerId()
					+ " does not exist");
		}
		ofy().save().entities(customer).now();
		return customer;
	}

	@ApiMethod(name = "editCustomer")
	public RequestResult editCustomer(CustomerDTO customerDto) {
		RequestResult re = new RequestResult();
		re.setSuccess(false);
		re.setResultMessage("Not Successful");

		try {
			Customer customerDTO = createCustomerFromDTO(customerDto);
			Customer customerexists = findRecord(customerDTO.getCustomerId());
			if (customerexists == null) {
				throw new NotFoundException("Customer "
						+ customerDto.getCustomerId() + " does not exist");
			}
			OrganizationEndpoint organizationEndpoint = new OrganizationEndpoint();
			customerexists.setCustomerId(customerexists.getCustomerId());
			customerexists.setAddress(customerDto.getAddress());
			customerexists.setBillToAddress(customerDto.getBillToAddress());
			customerexists.setBillToEmail(customerDto.getBillToEmail());
			customerexists.setBillToName(customerDto.getBillToName());
			customerexists.setBillToTelephone(customerDto.getBillToTelephone());
			customerexists.setBranch(customerDto.getBranch());
			customerexists.setCreatedDate(customerexists.getCreatedDate());
			customerexists.setCustomerNo(customerDto.getCustomerNo());
			customerexists.setEmail(customerDto.getEmail());
			customerexists.setMemberId(customerexists.getMemberId());
			customerexists.setName(customerDto.getName());
			customerexists.setOrganization(organizationEndpoint
					.getOrganization(customerDto.getOrganization()));
			customerexists.setTelephone(customerDto.getTelephone());

			ofy().save().entities(customerexists).now();
			re.setResultMessage("Customer Updated.<br/>Id = "
					+ customerexists.getCustomerId());
			re.setSuccess(true);
			return re;
		} catch (Exception e) {
			e.printStackTrace();
			re.setSuccess(false);
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
	@ApiMethod(name = "removeCustomer")
	public RequestResult removeCustomer(@Named("id") Long id) {
		RequestResult re = new RequestResult();
		re.setSuccess(false);
		re.setResultMessage("Not Successful");
		try {
			Customer record = findRecord(id);
			if (record == null) {
				throw new NotFoundException("Customer " + id
						+ " does not exist");
			}
			ofy().delete().entity(record).now();
			re.setResultMessage("Customer " + id + " Removed");
			re.setSuccess(true);
			return re;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re.setSuccess(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	private Customer findRecord(Long id) {
		return ofy().load().type(Customer.class).id(id).now();
	}

	private Customer createCustomerFromDTO(CustomerDTO customerDto) {
		// Construct Account
		OrganizationEndpoint organizationEndpoint = new OrganizationEndpoint();

		Customer customer = new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setAddress(customerDto.getAddress());
		customer.setBillToAddress(customerDto.getBillToAddress());
		customer.setBillToEmail(customerDto.getBillToEmail());
		customer.setBillToName(customerDto.getBillToName());
		customer.setBillToTelephone(customerDto.getBillToTelephone());
		customer.setBranch(customerDto.getBranch());
		customer.setCreatedDate(new Date());
		customer.setCustomerNo(customerDto.getCustomerNo());
		customer.setEmail(customerDto.getEmail());
		customer.setMemberId(customerDto.getMemberId());
		customer.setName(customerDto.getName());
		customer.setOrganization(organizationEndpoint
				.getOrganization(customerDto.getOrganization()));
		customer.setTelephone(customerDto.getTelephone());

		return customer;
	}

	private CustomerDTO createDTOFromCustomer(Customer customer) {
		// Construct dto
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setAddress(customer.getAddress());
		customerDto.setBillToAddress(customer.getBillToAddress());
		customerDto.setBillToEmail(customer.getBillToEmail());
		customerDto.setBillToName(customer.getBillToName());
		customerDto.setBillToTelephone(customer.getBillToTelephone());
		customerDto.setBranch(customer.getBranch());
		customerDto.setCreatedDate(customer.getCreatedDate());
		customerDto.setCustomerNo(customer.getCustomerNo());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMemberId(customer.getMemberId());
		customerDto.setName(customer.getName());
		customerDto.setOrganization(customer.getOrganization()
				.getOrganizationID());
		customerDto.setTelephone(customer.getTelephone());

		return customerDto;
	}
}
