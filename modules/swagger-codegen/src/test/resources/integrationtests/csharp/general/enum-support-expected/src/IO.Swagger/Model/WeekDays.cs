/* 
 * My title
 *
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1
 * 
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */

using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using System.ComponentModel.DataAnnotations;
using SwaggerDateConverter = IO.Swagger.Client.SwaggerDateConverter;

namespace IO.Swagger.Model
{
    /// <summary>
    /// Defines WeekDays
    /// </summary>
    
    [JsonConverter(typeof(StringEnumConverter))]
    
    public enum WeekDays
    {
        
        /// <summary>
        /// Enum Sun for value: sun
        /// </summary>
        [EnumMember(Value = "sun")]
        Sun,
        
        /// <summary>
        /// Enum Mon for value: mon
        /// </summary>
        [EnumMember(Value = "mon")]
        Mon,
        
        /// <summary>
        /// Enum Tue for value: tue
        /// </summary>
        [EnumMember(Value = "tue")]
        Tue,
        
        /// <summary>
        /// Enum Wed for value: wed
        /// </summary>
        [EnumMember(Value = "wed")]
        Wed,
        
        /// <summary>
        /// Enum Thu for value: thu
        /// </summary>
        [EnumMember(Value = "thu")]
        Thu,
        
        /// <summary>
        /// Enum Fri for value: fri
        /// </summary>
        [EnumMember(Value = "fri")]
        Fri,
        
        /// <summary>
        /// Enum Sat for value: sat
        /// </summary>
        [EnumMember(Value = "sat")]
        Sat
    }

}
