<?php
/**
 * PetApi
 * PHP version 5
 *
 * @category Class
 * @package  Swagger\Client
 * @author   Swagger Codegen team
 * @link     https://github.com/swagger-api/swagger-codegen
 */

/**
 * Swagger Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 */

/**
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

namespace Swagger\Client\Api;

use \Swagger\Client\ApiClient;
use \Swagger\Client\ApiException;
use \Swagger\Client\Configuration;
use \Swagger\Client\ObjectSerializer;

/**
 * PetApi Class Doc Comment
 *
 * @category Class
 * @package  Swagger\Client
 * @author   Swagger Codegen team
 * @link     https://github.com/swagger-api/swagger-codegen
 */
class PetApi
{
    /**
     * API Client
     *
     * @var \Swagger\Client\ApiClient instance of the ApiClient
     */
    protected $apiClient;

    /**
     * Constructor
     *
     * @param \Swagger\Client\ApiClient|null $apiClient The api client to use
     */
    public function __construct(\Swagger\Client\ApiClient $apiClient = null)
    {
        if ($apiClient === null) {
            $apiClient = new ApiClient();
        }

        $this->apiClient = $apiClient;
    }

    /**
     * Get API client
     *
     * @return \Swagger\Client\ApiClient get the API client
     */
    public function getApiClient()
    {
        return $this->apiClient;
    }

    /**
     * Set the API client
     *
     * @param \Swagger\Client\ApiClient $apiClient set the API client
     *
     * @return PetApi
     */
    public function setApiClient(\Swagger\Client\ApiClient $apiClient)
    {
        $this->apiClient = $apiClient;
        return $this;
    }

    /**
     * Operation addPet
     *
     * Add a new pet to the store
     *
     * @param \Swagger\Client\Model\Pet $body Pet object that needs to be added to the store (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return void
     */
    public function addPet($body)
    {
        list($response) = $this->addPetWithHttpInfo($body);
        return $response;
    }

    /**
     * Operation addPetWithHttpInfo
     *
     * Add a new pet to the store
     *
     * @param \Swagger\Client\Model\Pet $body Pet object that needs to be added to the store (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of null, HTTP status code, HTTP response headers (array of strings)
     */
    public function addPetWithHttpInfo($body)
    {
        // verify the required parameter 'body' is set
        if ($body === null) {
            throw new \InvalidArgumentException('Missing the required parameter $body when calling addPet');
        }
        // parse inputs
        $resourcePath = "/pet";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/xml', 'application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType(['application/json', 'application/xml']);

        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        // body params
        $_tempBody = null;
        if (isset($body)) {
            $_tempBody = $body;
        }

        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires OAuth (access token)
        if (strlen($this->apiClient->getConfig()->getAccessToken()) !== 0) {
            $headerParams['Authorization'] = 'Bearer ' . $this->apiClient->getConfig()->getAccessToken();
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'POST',
                $queryParams,
                $httpBody,
                $headerParams,
                null,
                '/pet'
            );

            return [null, $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
            }

            throw $e;
        }
    }

    /**
     * Operation deletePet
     *
     * Deletes a pet
     *
     * @param int $pet_id Pet id to delete (required)
     * @param string $api_key  (optional)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return void
     */
    public function deletePet($pet_id, $api_key = null)
    {
        list($response) = $this->deletePetWithHttpInfo($pet_id, $api_key);
        return $response;
    }

    /**
     * Operation deletePetWithHttpInfo
     *
     * Deletes a pet
     *
     * @param int $pet_id Pet id to delete (required)
     * @param string $api_key  (optional)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of null, HTTP status code, HTTP response headers (array of strings)
     */
    public function deletePetWithHttpInfo($pet_id, $api_key = null)
    {
        // verify the required parameter 'pet_id' is set
        if ($pet_id === null) {
            throw new \InvalidArgumentException('Missing the required parameter $pet_id when calling deletePet');
        }
        // parse inputs
        $resourcePath = "/pet/{petId}";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/xml', 'application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType([]);

        // header params
        if ($api_key !== null) {
            $headerParams['api_key'] = $this->apiClient->getSerializer()->toHeaderValue($api_key);
        }
        // path params
        if ($pet_id !== null) {
            $resourcePath = str_replace(
                "{" . "petId" . "}",
                $this->apiClient->getSerializer()->toPathValue($pet_id),
                $resourcePath
            );
        }
        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        
        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires OAuth (access token)
        if (strlen($this->apiClient->getConfig()->getAccessToken()) !== 0) {
            $headerParams['Authorization'] = 'Bearer ' . $this->apiClient->getConfig()->getAccessToken();
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'DELETE',
                $queryParams,
                $httpBody,
                $headerParams,
                null,
                '/pet/{petId}'
            );

            return [null, $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
            }

            throw $e;
        }
    }

    /**
     * Operation findPetsByStatus
     *
     * Finds Pets by status
     *
     * @param string[] $status Status values that need to be considered for filter (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return \Swagger\Client\Model\Pet[]
     */
    public function findPetsByStatus($status)
    {
        list($response) = $this->findPetsByStatusWithHttpInfo($status);
        return $response;
    }

    /**
     * Operation findPetsByStatusWithHttpInfo
     *
     * Finds Pets by status
     *
     * @param string[] $status Status values that need to be considered for filter (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of \Swagger\Client\Model\Pet[], HTTP status code, HTTP response headers (array of strings)
     */
    public function findPetsByStatusWithHttpInfo($status)
    {
        // verify the required parameter 'status' is set
        if ($status === null) {
            throw new \InvalidArgumentException('Missing the required parameter $status when calling findPetsByStatus');
        }
        // parse inputs
        $resourcePath = "/pet/findByStatus";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/xml', 'application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType([]);

        // query params
        if (is_array($status)) {
            $status = $this->apiClient->getSerializer()->serializeCollection($status, 'csv', true);
        }
        if ($status !== null) {
            $queryParams['status'] = $this->apiClient->getSerializer()->toQueryValue($status);
        }
        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        
        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires OAuth (access token)
        if (strlen($this->apiClient->getConfig()->getAccessToken()) !== 0) {
            $headerParams['Authorization'] = 'Bearer ' . $this->apiClient->getConfig()->getAccessToken();
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'GET',
                $queryParams,
                $httpBody,
                $headerParams,
                '\Swagger\Client\Model\Pet[]',
                '/pet/findByStatus'
            );

            return [$this->apiClient->getSerializer()->deserialize($response, '\Swagger\Client\Model\Pet[]', $httpHeader), $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
                case 200:
                    $data = $this->apiClient->getSerializer()->deserialize($e->getResponseBody(), '\Swagger\Client\Model\Pet[]', $e->getResponseHeaders());
                    $e->setResponseObject($data);
                    break;
            }

            throw $e;
        }
    }

    /**
     * Operation findPetsByTags
     *
     * Finds Pets by tags
     *
     * @param string[] $tags Tags to filter by (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return \Swagger\Client\Model\Pet[]
     */
    public function findPetsByTags($tags)
    {
        list($response) = $this->findPetsByTagsWithHttpInfo($tags);
        return $response;
    }

    /**
     * Operation findPetsByTagsWithHttpInfo
     *
     * Finds Pets by tags
     *
     * @param string[] $tags Tags to filter by (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of \Swagger\Client\Model\Pet[], HTTP status code, HTTP response headers (array of strings)
     */
    public function findPetsByTagsWithHttpInfo($tags)
    {
        // verify the required parameter 'tags' is set
        if ($tags === null) {
            throw new \InvalidArgumentException('Missing the required parameter $tags when calling findPetsByTags');
        }
        // parse inputs
        $resourcePath = "/pet/findByTags";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/xml', 'application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType([]);

        // query params
        if (is_array($tags)) {
            $tags = $this->apiClient->getSerializer()->serializeCollection($tags, 'csv', true);
        }
        if ($tags !== null) {
            $queryParams['tags'] = $this->apiClient->getSerializer()->toQueryValue($tags);
        }
        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        
        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires OAuth (access token)
        if (strlen($this->apiClient->getConfig()->getAccessToken()) !== 0) {
            $headerParams['Authorization'] = 'Bearer ' . $this->apiClient->getConfig()->getAccessToken();
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'GET',
                $queryParams,
                $httpBody,
                $headerParams,
                '\Swagger\Client\Model\Pet[]',
                '/pet/findByTags'
            );

            return [$this->apiClient->getSerializer()->deserialize($response, '\Swagger\Client\Model\Pet[]', $httpHeader), $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
                case 200:
                    $data = $this->apiClient->getSerializer()->deserialize($e->getResponseBody(), '\Swagger\Client\Model\Pet[]', $e->getResponseHeaders());
                    $e->setResponseObject($data);
                    break;
            }

            throw $e;
        }
    }

    /**
     * Operation getPetById
     *
     * Find pet by ID
     *
     * @param int $pet_id ID of pet to return (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return \Swagger\Client\Model\Pet
     */
    public function getPetById($pet_id)
    {
        list($response) = $this->getPetByIdWithHttpInfo($pet_id);
        return $response;
    }

    /**
     * Operation getPetByIdWithHttpInfo
     *
     * Find pet by ID
     *
     * @param int $pet_id ID of pet to return (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of \Swagger\Client\Model\Pet, HTTP status code, HTTP response headers (array of strings)
     */
    public function getPetByIdWithHttpInfo($pet_id)
    {
        // verify the required parameter 'pet_id' is set
        if ($pet_id === null) {
            throw new \InvalidArgumentException('Missing the required parameter $pet_id when calling getPetById');
        }
        // parse inputs
        $resourcePath = "/pet/{petId}";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/xml', 'application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType([]);

        // path params
        if ($pet_id !== null) {
            $resourcePath = str_replace(
                "{" . "petId" . "}",
                $this->apiClient->getSerializer()->toPathValue($pet_id),
                $resourcePath
            );
        }
        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        
        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires API key authentication
        $apiKey = $this->apiClient->getApiKeyWithPrefix('api_key');
        if (strlen($apiKey) !== 0) {
            $headerParams['api_key'] = $apiKey;
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'GET',
                $queryParams,
                $httpBody,
                $headerParams,
                '\Swagger\Client\Model\Pet',
                '/pet/{petId}'
            );

            return [$this->apiClient->getSerializer()->deserialize($response, '\Swagger\Client\Model\Pet', $httpHeader), $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
                case 200:
                    $data = $this->apiClient->getSerializer()->deserialize($e->getResponseBody(), '\Swagger\Client\Model\Pet', $e->getResponseHeaders());
                    $e->setResponseObject($data);
                    break;
            }

            throw $e;
        }
    }

    /**
     * Operation updatePet
     *
     * Update an existing pet
     *
     * @param \Swagger\Client\Model\Pet $body Pet object that needs to be added to the store (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return void
     */
    public function updatePet($body)
    {
        list($response) = $this->updatePetWithHttpInfo($body);
        return $response;
    }

    /**
     * Operation updatePetWithHttpInfo
     *
     * Update an existing pet
     *
     * @param \Swagger\Client\Model\Pet $body Pet object that needs to be added to the store (required)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of null, HTTP status code, HTTP response headers (array of strings)
     */
    public function updatePetWithHttpInfo($body)
    {
        // verify the required parameter 'body' is set
        if ($body === null) {
            throw new \InvalidArgumentException('Missing the required parameter $body when calling updatePet');
        }
        // parse inputs
        $resourcePath = "/pet";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/xml', 'application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType(['application/json', 'application/xml']);

        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        // body params
        $_tempBody = null;
        if (isset($body)) {
            $_tempBody = $body;
        }

        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires OAuth (access token)
        if (strlen($this->apiClient->getConfig()->getAccessToken()) !== 0) {
            $headerParams['Authorization'] = 'Bearer ' . $this->apiClient->getConfig()->getAccessToken();
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'PUT',
                $queryParams,
                $httpBody,
                $headerParams,
                null,
                '/pet'
            );

            return [null, $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
            }

            throw $e;
        }
    }

    /**
     * Operation updatePetWithForm
     *
     * Updates a pet in the store with form data
     *
     * @param int $pet_id ID of pet that needs to be updated (required)
     * @param string $name Updated name of the pet (optional)
     * @param string $status Updated status of the pet (optional)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return void
     */
    public function updatePetWithForm($pet_id, $name = null, $status = null)
    {
        list($response) = $this->updatePetWithFormWithHttpInfo($pet_id, $name, $status);
        return $response;
    }

    /**
     * Operation updatePetWithFormWithHttpInfo
     *
     * Updates a pet in the store with form data
     *
     * @param int $pet_id ID of pet that needs to be updated (required)
     * @param string $name Updated name of the pet (optional)
     * @param string $status Updated status of the pet (optional)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of null, HTTP status code, HTTP response headers (array of strings)
     */
    public function updatePetWithFormWithHttpInfo($pet_id, $name = null, $status = null)
    {
        // verify the required parameter 'pet_id' is set
        if ($pet_id === null) {
            throw new \InvalidArgumentException('Missing the required parameter $pet_id when calling updatePetWithForm');
        }
        // parse inputs
        $resourcePath = "/pet/{petId}";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/xml', 'application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType(['application/x-www-form-urlencoded']);

        // path params
        if ($pet_id !== null) {
            $resourcePath = str_replace(
                "{" . "petId" . "}",
                $this->apiClient->getSerializer()->toPathValue($pet_id),
                $resourcePath
            );
        }
        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        // form params
        if ($name !== null) {
            $formParams['name'] = $this->apiClient->getSerializer()->toFormValue($name);
        }
        // form params
        if ($status !== null) {
            $formParams['status'] = $this->apiClient->getSerializer()->toFormValue($status);
        }
        
        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires OAuth (access token)
        if (strlen($this->apiClient->getConfig()->getAccessToken()) !== 0) {
            $headerParams['Authorization'] = 'Bearer ' . $this->apiClient->getConfig()->getAccessToken();
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'POST',
                $queryParams,
                $httpBody,
                $headerParams,
                null,
                '/pet/{petId}'
            );

            return [null, $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
            }

            throw $e;
        }
    }

    /**
     * Operation uploadFile
     *
     * uploads an image
     *
     * @param int $pet_id ID of pet to update (required)
     * @param string $additional_metadata Additional data to pass to server (optional)
     * @param \SplFileObject $file file to upload (optional)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return \Swagger\Client\Model\ApiResponse
     */
    public function uploadFile($pet_id, $additional_metadata = null, $file = null)
    {
        list($response) = $this->uploadFileWithHttpInfo($pet_id, $additional_metadata, $file);
        return $response;
    }

    /**
     * Operation uploadFileWithHttpInfo
     *
     * uploads an image
     *
     * @param int $pet_id ID of pet to update (required)
     * @param string $additional_metadata Additional data to pass to server (optional)
     * @param \SplFileObject $file file to upload (optional)
     * @throws \Swagger\Client\ApiException on non-2xx response
     * @return array of \Swagger\Client\Model\ApiResponse, HTTP status code, HTTP response headers (array of strings)
     */
    public function uploadFileWithHttpInfo($pet_id, $additional_metadata = null, $file = null)
    {
        // verify the required parameter 'pet_id' is set
        if ($pet_id === null) {
            throw new \InvalidArgumentException('Missing the required parameter $pet_id when calling uploadFile');
        }
        // parse inputs
        $resourcePath = "/pet/{petId}/uploadImage";
        $httpBody = '';
        $queryParams = [];
        $headerParams = [];
        $formParams = [];
        $_header_accept = $this->apiClient->selectHeaderAccept(['application/json']);
        if (!is_null($_header_accept)) {
            $headerParams['Accept'] = $_header_accept;
        }
        $headerParams['Content-Type'] = $this->apiClient->selectHeaderContentType(['multipart/form-data']);

        // path params
        if ($pet_id !== null) {
            $resourcePath = str_replace(
                "{" . "petId" . "}",
                $this->apiClient->getSerializer()->toPathValue($pet_id),
                $resourcePath
            );
        }
        // default format to json
        $resourcePath = str_replace("{format}", "json", $resourcePath);

        // form params
        if ($additional_metadata !== null) {
            $formParams['additionalMetadata'] = $this->apiClient->getSerializer()->toFormValue($additional_metadata);
        }
        // form params
        if ($file !== null) {
            // PHP 5.5 introduced a CurlFile object that deprecates the old @filename syntax
            // See: https://wiki.php.net/rfc/curl-file-upload
            if (function_exists('curl_file_create')) {
                $formParams['file'] = curl_file_create($this->apiClient->getSerializer()->toFormValue($file));
            } else {
                $formParams['file'] = '@' . $this->apiClient->getSerializer()->toFormValue($file);
            }
        }
        
        // for model (json/xml)
        if (isset($_tempBody)) {
            $httpBody = $_tempBody; // $_tempBody is the method argument, if present
        } elseif (count($formParams) > 0) {
            $httpBody = $formParams; // for HTTP post (form)
        }
        // this endpoint requires OAuth (access token)
        if (strlen($this->apiClient->getConfig()->getAccessToken()) !== 0) {
            $headerParams['Authorization'] = 'Bearer ' . $this->apiClient->getConfig()->getAccessToken();
        }
        // make the API Call
        try {
            list($response, $statusCode, $httpHeader) = $this->apiClient->callApi(
                $resourcePath,
                'POST',
                $queryParams,
                $httpBody,
                $headerParams,
                '\Swagger\Client\Model\ApiResponse',
                '/pet/{petId}/uploadImage'
            );

            return [$this->apiClient->getSerializer()->deserialize($response, '\Swagger\Client\Model\ApiResponse', $httpHeader), $statusCode, $httpHeader];
        } catch (ApiException $e) {
            switch ($e->getCode()) {
                case 200:
                    $data = $this->apiClient->getSerializer()->deserialize($e->getResponseBody(), '\Swagger\Client\Model\ApiResponse', $e->getResponseHeaders());
                    $e->setResponseObject($data);
                    break;
            }

            throw $e;
        }
    }
}
