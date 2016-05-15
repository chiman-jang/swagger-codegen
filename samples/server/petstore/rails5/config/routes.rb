Rails.application.routes.draw do

  def add_swagger_route http_method, path, opts = {}
    full_path = path.gsub(/{(.*?)}/, ':\1')
    match full_path, to: "#{opts.fetch(:controller_name)}##{opts[:action_name]}", via: http_method
  end

  add_swagger_route 'POST', '/v2/pet', controller_name: 'pet', action_name: 'create'
  add_swagger_route 'DELETE', '/v2/pet/{petId}', controller_name: 'pet', action_name: 'destroy'
  add_swagger_route 'GET', '/v2/pet/findByStatus', controller_name: 'pet', action_name: 'find_pets_by_status'
  add_swagger_route 'GET', '/v2/pet/findByTags', controller_name: 'pet', action_name: 'find_pets_by_tags'
  add_swagger_route 'GET', '/v2/pet/{petId}', controller_name: 'pet', action_name: 'show'
  add_swagger_route 'PUT', '/v2/pet', controller_name: 'pet', action_name: 'update_pet'
  add_swagger_route 'POST', '/v2/pet/{petId}', controller_name: 'pet', action_name: 'update_pet_with_form'
  add_swagger_route 'POST', '/v2/pet/{petId}/uploadImage', controller_name: 'pet', action_name: 'upload_file'
  add_swagger_route 'DELETE', '/v2/store/order/{orderId}', controller_name: 'store', action_name: 'delete_order'
  add_swagger_route 'GET', '/v2/store/inventory', controller_name: 'store', action_name: 'get_inventory'
  add_swagger_route 'GET', '/v2/store/order/{orderId}', controller_name: 'store', action_name: 'get_order_by_id'
  add_swagger_route 'POST', '/v2/store/order', controller_name: 'store', action_name: 'place_order'
  add_swagger_route 'POST', '/v2/user', controller_name: 'user', action_name: 'create'
  add_swagger_route 'POST', '/v2/user/createWithArray', controller_name: 'user', action_name: 'create_users_with_array_input'
  add_swagger_route 'POST', '/v2/user/createWithList', controller_name: 'user', action_name: 'create_users_with_list_input'
  add_swagger_route 'DELETE', '/v2/user/{username}', controller_name: 'user', action_name: 'destroy'
  add_swagger_route 'GET', '/v2/user/{username}', controller_name: 'user', action_name: 'show'
  add_swagger_route 'GET', '/v2/user/login', controller_name: 'user', action_name: 'login_user'
  add_swagger_route 'GET', '/v2/user/logout', controller_name: 'user', action_name: 'logout_user'
  add_swagger_route 'PUT', '/v2/user/{username}', controller_name: 'user', action_name: 'update'
end
