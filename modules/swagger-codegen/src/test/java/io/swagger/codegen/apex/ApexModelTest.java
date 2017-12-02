package io.swagger.codegen.apex;

import io.swagger.codegen.CodegenConstants;
import io.swagger.codegen.CodegenModel;
import io.swagger.codegen.CodegenProperty;
import io.swagger.codegen.languages.ApexClientCodegen;
import io.swagger.oas.models.media.BinarySchema;
import io.swagger.oas.models.media.BooleanSchema;
import io.swagger.oas.models.media.ByteArraySchema;
import io.swagger.oas.models.media.DateTimeSchema;
import io.swagger.oas.models.media.EmailSchema;
import io.swagger.oas.models.media.IntegerSchema;
import io.swagger.oas.models.media.NumberSchema;
import io.swagger.oas.models.media.PasswordSchema;
import io.swagger.oas.models.media.Schema;
import io.swagger.oas.models.media.StringSchema;
import io.swagger.oas.models.media.UUIDSchema;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.swagger.codegen.languages.helpers.ExtensionHelper.getBooleanValue;

@SuppressWarnings("static-method")
public class ApexModelTest {

    @Test(description = "convert a simple apex model with provided examples")
    public void examplesProvidedTest() {
        Schema integerSchema = new IntegerSchema().example(5);
        Schema passwordSchema = new PasswordSchema().example("password");
        Schema uuidSchema = new UUIDSchema().example("793574b2-3a8e-4f6c-bfa5-c6929dc29f8a");

        final Schema schema = new Schema()
            .addProperties("boolProp", new BooleanSchema().example(false))
            .addProperties("dateProp", new DateTimeSchema().example("1985-04-12"))
            .addProperties("dateTimeProp", new DateTimeSchema().example("1985-04-12T23:20:50.52Z"))
            .addProperties("decimalProp", new NumberSchema().example("19.99"))
            .addProperties("doubleProp", new NumberSchema().example(2.95))
            .addProperties("emailProp", new EmailSchema().example("info@example.com"))
            .addProperties("floatProp", new NumberSchema().format("float").example(3.49f))
            .addProperties("intProp", new IntegerSchema().example(10))
            .addProperties("longProp", new IntegerSchema().example(100000L))
            .addProperties("stringProp", new StringSchema().example("foo"))
            .addProperties("baseIntProp", integerSchema)
            .addProperties("passwordProp", passwordSchema)
            .addProperties("uuidProp", uuidSchema);

        final ApexClientCodegen codegen = new ApexClientCodegen();
        codegen.setClassPrefix("Prefix");
        final CodegenModel cm = codegen.fromModel("sample", schema);

        Assert.assertEquals(cm.name, "sample");
        Assert.assertEquals(cm.classname, "PrefixSample");
        Assert.assertEquals(cm.vars.size(), 13);

        final List<CodegenProperty> vars = cm.vars;

        final CodegenProperty property1 = vars.get(0);
        Assert.assertEquals(property1.name, "boolProp");
        Assert.assertEquals(property1.baseName, "boolProp");
        Assert.assertEquals(property1.datatype, "Boolean");
        Assert.assertEquals(property1.baseType, "Boolean");
        Assert.assertEquals(property1.example, "false");
        Assert.assertNull(property1.defaultValue);
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_BOOLEAN_EXT_NAME));

        final CodegenProperty property2 = vars.get(1);
        Assert.assertEquals(property2.name, "dateProp");
        Assert.assertEquals(property2.baseName, "dateProp");
        Assert.assertEquals(property2.datatype, "Date");
        Assert.assertEquals(property2.baseType, "Date");
        Assert.assertEquals(property2.example, "Date.newInstance(1985, 4, 12)");
        Assert.assertNull(property2.defaultValue);
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_DATE_EXT_NAME));

        final CodegenProperty property3 = vars.get(2);
        Assert.assertEquals(property3.name, "dateTimeProp");
        Assert.assertEquals(property3.baseName, "dateTimeProp");
        Assert.assertEquals(property3.datatype, "Datetime");
        Assert.assertEquals(property3.baseType, "Datetime");
        Assert.assertEquals(property3.example, "Datetime.newInstanceGmt(1985, 4, 12, 23, 20, 50)");
        Assert.assertNull(property3.defaultValue);
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.IS_DATE_TIME_EXT_NAME));

        final CodegenProperty property4 = vars.get(3);
        Assert.assertEquals(property4.name, "decimalProp");
        Assert.assertEquals(property4.baseName, "decimalProp");
        Assert.assertEquals(property4.datatype, "Double");
        Assert.assertEquals(property4.baseType, "Double");
        Assert.assertEquals(property4.example, "19.99");
        Assert.assertNull(property4.defaultValue);
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property5 = vars.get(4);
        Assert.assertEquals(property5.name, "doubleProp");
        Assert.assertEquals(property5.baseName, "doubleProp");
        Assert.assertEquals(property5.datatype, "Double");
        Assert.assertEquals(property5.baseType, "Double");
        Assert.assertEquals(property5.example, "2.95");
        Assert.assertNull(property5.defaultValue);
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.IS_DOUBLE_EXT_NAME));

        final CodegenProperty property6 = vars.get(5);
        Assert.assertEquals(property6.name, "emailProp");
        Assert.assertEquals(property6.baseName, "emailProp");
        Assert.assertEquals(property6.datatype, "String");
        Assert.assertEquals(property6.baseType, "String");
        Assert.assertEquals(property6.example, "'info@example.com'");
        Assert.assertNull(property6.defaultValue);
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.IS_STRING_EXT_NAME));

        final CodegenProperty property7 = vars.get(6);
        Assert.assertEquals(property7.name, "floatProp");
        Assert.assertEquals(property7.baseName, "floatProp");
        Assert.assertEquals(property7.datatype, "Double");
        Assert.assertEquals(property7.baseType, "Double");
        Assert.assertEquals(property7.example, "3.49");
        Assert.assertNull(property7.defaultValue);
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.IS_FLOAT_EXT_NAME));

        final CodegenProperty property8 = vars.get(7);
        Assert.assertEquals(property8.name, "intProp");
        Assert.assertEquals(property8.baseName, "intProp");
        Assert.assertEquals(property8.datatype, "Integer");
        Assert.assertEquals(property8.baseType, "Integer");
        Assert.assertEquals(property8.example, "10");
        Assert.assertNull(property8.defaultValue);
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.IS_INTEGER_EXT_NAME));

        final CodegenProperty property9 = vars.get(8);
        Assert.assertEquals(property9.name, "longProp");
        Assert.assertEquals(property9.baseName, "longProp");
        Assert.assertEquals(property9.datatype, "Long");
        Assert.assertEquals(property9.baseType, "Long");
        Assert.assertEquals(property9.example, "100000L");
        Assert.assertNull(property9.defaultValue);
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.IS_LONG_EXT_NAME));

        final CodegenProperty property10 = vars.get(9);
        Assert.assertEquals(property10.name, "stringProp");
        Assert.assertEquals(property10.baseName, "stringProp");
        Assert.assertEquals(property10.datatype, "String");
        Assert.assertEquals(property10.baseType, "String");
        Assert.assertEquals(property10.example, "'foo'");
        Assert.assertNull(property10.defaultValue);
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.IS_STRING_EXT_NAME));

        final CodegenProperty property11 = vars.get(10);
        Assert.assertEquals(property11.name, "baseIntProp");
        Assert.assertEquals(property11.baseName, "baseIntProp");
        Assert.assertEquals(property11.datatype, "Integer");
        Assert.assertEquals(property11.baseType, "Integer");
        Assert.assertEquals(property11.example, "5");
        Assert.assertNull(property11.defaultValue);
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.IS_INTEGER_EXT_NAME));

        final CodegenProperty property12 = vars.get(11);
        Assert.assertEquals(property12.name, "passwordProp");
        Assert.assertEquals(property12.baseName, "passwordProp");
        Assert.assertEquals(property12.datatype, "String");
        Assert.assertEquals(property12.baseType, "String");
        Assert.assertEquals(property12.example, "'password'");
        Assert.assertNull(property12.defaultValue);
        Assert.assertTrue(getBooleanValue(property12, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property12, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property12, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property13 = vars.get(12);
        Assert.assertEquals(property13.name, "uuidProp");
        Assert.assertEquals(property13.baseName, "uuidProp");
        Assert.assertEquals(property13.datatype, "String");
        Assert.assertEquals(property13.baseType, "String");
        Assert.assertEquals(property13.example, "'793574b2-3a8e-4f6c-bfa5-c6929dc29f8a'");
        Assert.assertNull(property13.defaultValue);
        Assert.assertFalse(getBooleanValue(property13, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property13, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property13, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
    }
    
    @Test(description = "convert a simple apex model with default examples")
    public void defaultExamplesTest() {
        final Schema schema = new Schema()
            .addProperties("boolProp", new BooleanSchema())
            .addProperties("dateProp", new DateTimeSchema())
            .addProperties("dateTimeProp", new DateTimeSchema())
            .addProperties("decimalProp", new NumberSchema())
            .addProperties("doubleProp", new NumberSchema())
            .addProperties("emailProp", new EmailSchema())
            .addProperties("floatProp", new NumberSchema())
            .addProperties("intProp", new IntegerSchema())
            .addProperties("longProp", new IntegerSchema())
            .addProperties("stringProp", new StringSchema())
            .addProperties("baseIntProp", new IntegerSchema())
            .addProperties("passwordProp", new PasswordSchema())
            .addProperties("uuidProp", new UUIDSchema())
            .addProperties("byteArrProp", new ByteArraySchema())
            .addProperties("binaryProp", new BinarySchema());

        final ApexClientCodegen codegen = new ApexClientCodegen();
        codegen.setClassPrefix("Prefix");
        final CodegenModel cm = codegen.fromModel("sample", schema);

        Assert.assertEquals(cm.name, "sample");
        Assert.assertEquals(cm.classname, "PrefixSample");
        Assert.assertEquals(cm.vars.size(), 15);

        final List<CodegenProperty> vars = cm.vars;

        final CodegenProperty property1 = vars.get(0);
        Assert.assertEquals(property1.name, "boolProp");
        Assert.assertEquals(property1.baseName, "boolProp");
        Assert.assertEquals(property1.datatype, "Boolean");
        Assert.assertEquals(property1.baseType, "Boolean");
        Assert.assertEquals(property1.example, "true");
        Assert.assertNull(property1.defaultValue);
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_INTEGER_EXT_NAME));

        final CodegenProperty property2 = vars.get(1);
        Assert.assertEquals(property2.name, "dateProp");
        Assert.assertEquals(property2.baseName, "dateProp");
        Assert.assertEquals(property2.datatype, "Date");
        Assert.assertEquals(property2.baseType, "Date");
        Assert.assertEquals(property2.example, "Date.newInstance(2000, 1, 23)");
        Assert.assertNull(property2.defaultValue);
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_DATE_EXT_NAME));

        final CodegenProperty property3 = vars.get(2);
        Assert.assertEquals(property3.name, "dateTimeProp");
        Assert.assertEquals(property3.baseName, "dateTimeProp");
        Assert.assertEquals(property3.datatype, "Datetime");
        Assert.assertEquals(property3.baseType, "Datetime");
        Assert.assertEquals(property3.example, "Datetime.newInstanceGmt(2000, 1, 23, 4, 56, 7)");
        Assert.assertNull(property3.defaultValue);
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.IS_DATE_TIME_EXT_NAME));

        final CodegenProperty property4 = vars.get(3);
        Assert.assertEquals(property4.name, "decimalProp");
        Assert.assertEquals(property4.baseName, "decimalProp");
        Assert.assertEquals(property4.datatype, "Double");
        Assert.assertEquals(property4.baseType, "Double");
        Assert.assertEquals(property4.example, "1.3579");
        Assert.assertNull(property4.defaultValue);
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property5 = vars.get(4);
        Assert.assertEquals(property5.name, "doubleProp");
        Assert.assertEquals(property5.baseName, "doubleProp");
        Assert.assertEquals(property5.datatype, "Double");
        Assert.assertEquals(property5.baseType, "Double");
        Assert.assertEquals(property5.example, "1.3579");
        Assert.assertNull(property5.defaultValue);
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.IS_DOUBLE_EXT_NAME));

        final CodegenProperty property6 = vars.get(5);
        Assert.assertEquals(property6.name, "emailProp");
        Assert.assertEquals(property6.baseName, "emailProp");
        Assert.assertEquals(property6.datatype, "String");
        Assert.assertEquals(property6.baseType, "String");
        Assert.assertEquals(property6.example, "'example@example.com'");
        Assert.assertNull(property6.defaultValue);
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.IS_STRING_EXT_NAME));

        final CodegenProperty property7 = vars.get(6);
        Assert.assertEquals(property7.name, "floatProp");
        Assert.assertEquals(property7.baseName, "floatProp");
        Assert.assertEquals(property7.datatype, "Double");
        Assert.assertEquals(property7.baseType, "Double");
        Assert.assertEquals(property7.example, "1.3579");
        Assert.assertNull(property7.defaultValue);
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.IS_FLOAT_EXT_NAME));

        final CodegenProperty property8 = vars.get(7);
        Assert.assertEquals(property8.name, "intProp");
        Assert.assertEquals(property8.baseName, "intProp");
        Assert.assertEquals(property8.datatype, "Integer");
        Assert.assertEquals(property8.baseType, "Integer");
        Assert.assertEquals(property8.example, "123");
        Assert.assertNull(property8.defaultValue);
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property8, CodegenConstants.IS_INTEGER_EXT_NAME));

        final CodegenProperty property9 = vars.get(8);
        Assert.assertEquals(property9.name, "longProp");
        Assert.assertEquals(property9.baseName, "longProp");
        Assert.assertEquals(property9.datatype, "Long");
        Assert.assertEquals(property9.baseType, "Long");
        Assert.assertEquals(property9.example, "123456789L");
        Assert.assertNull(property9.defaultValue);
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property9, CodegenConstants.IS_LONG_EXT_NAME));

        final CodegenProperty property10 = vars.get(9);
        Assert.assertEquals(property10.name, "stringProp");
        Assert.assertEquals(property10.baseName, "stringProp");
        Assert.assertEquals(property10.datatype, "String");
        Assert.assertEquals(property10.baseType, "String");
        Assert.assertEquals(property10.example, "'aeiou'");
        Assert.assertNull(property10.defaultValue);
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property10, CodegenConstants.IS_STRING_EXT_NAME));

        final CodegenProperty property11 = vars.get(10);
        Assert.assertEquals(property11.name, "baseIntProp");
        Assert.assertEquals(property11.baseName, "baseIntProp");
        Assert.assertEquals(property11.datatype, "Integer");
        Assert.assertEquals(property11.baseType, "Integer");
        Assert.assertEquals(property11.example, "123");
        Assert.assertNull(property11.defaultValue);
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property11, CodegenConstants.IS_INTEGER_EXT_NAME));

        final CodegenProperty property12 = vars.get(11);
        Assert.assertEquals(property12.name, "passwordProp");
        Assert.assertEquals(property12.baseName, "passwordProp");
        Assert.assertEquals(property12.datatype, "String");
        Assert.assertEquals(property12.baseType, "String");
        Assert.assertEquals(property12.example, "'password123'");
        Assert.assertNull(property12.defaultValue);
        Assert.assertTrue(getBooleanValue(property12, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property12, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property12, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property13 = vars.get(12);
        Assert.assertEquals(property13.name, "uuidProp");
        Assert.assertEquals(property13.baseName, "uuidProp");
        Assert.assertEquals(property13.datatype, "String");
        Assert.assertEquals(property13.baseType, "String");
        Assert.assertEquals(property13.example, "'046b6c7f-0b8a-43b9-b35d-6489e6daee91'");
        Assert.assertNull(property13.defaultValue);
        Assert.assertTrue(getBooleanValue(property13, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property13, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property13, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property14 = vars.get(13);
        Assert.assertEquals(property14.name, "byteArrProp");
        Assert.assertEquals(property14.baseName, "byteArrProp");
        Assert.assertEquals(property14.datatype, "Blob");
        Assert.assertEquals(property14.baseType, "Blob");
        Assert.assertEquals(property14.example, "EncodingUtil.base64Decode('VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wZWQgb3ZlciB0aGUgbGF6eSBkb2cu')");
        Assert.assertNull(property14.defaultValue);
        Assert.assertTrue(getBooleanValue(property14, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property14, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property14, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property14, CodegenConstants.IS_BYTE_ARRAY_EXT_NAME));

        final CodegenProperty property15 = vars.get(14);
        Assert.assertEquals(property15.name, "binaryProp");
        Assert.assertEquals(property15.baseName, "binaryProp");
        Assert.assertEquals(property15.datatype, "String");
        Assert.assertEquals(property15.baseType, "String");
        Assert.assertEquals(property15.example, "");
        Assert.assertNull(property15.defaultValue);
        Assert.assertTrue(getBooleanValue(property15, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property15, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property15, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property15, CodegenConstants.IS_BINARY_EXT_NAME));
    }
//
//    @Test(description = "convert a model with list property")
//    public void listPropertyTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("id", new LongProperty())
//                .property("urls", new ArrayProperty()
//                        .items(new StringProperty()))
//                .required("id");
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "a sample model");
//        Assert.assertEquals(cm.vars.size(), 2);
//
//        final CodegenProperty property = cm.vars.get(1);
//        Assert.assertEquals(property.baseName, "urls");
//        Assert.assertEquals(property.getter, "getUrls");
//        Assert.assertEquals(property.setter, "setUrls");
//        Assert.assertEquals(property.datatype, "List<String>");
//        Assert.assertEquals(property.name, "urls");
//        Assert.assertEquals(property.defaultValue, "new ArrayList<String>()");
//        Assert.assertEquals(property.baseType, "List");
//        Assert.assertEquals(property.containerType, "array");
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isContainer);
//    }
//
//    @Test(description = "convert a model with a map property")
//    public void mapPropertyTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("translations", new MapProperty()
//                        .additionalProperties(new StringProperty()))
//                .required("id");
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "a sample model");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "translations");
//        Assert.assertEquals(property.getter, "getTranslations");
//        Assert.assertEquals(property.setter, "setTranslations");
//        Assert.assertEquals(property.datatype, "Map<String, String>");
//        Assert.assertEquals(property.name, "translations");
//        Assert.assertEquals(property.defaultValue, "new HashMap<String, String>()");
//        Assert.assertEquals(property.baseType, "Map");
//        Assert.assertEquals(property.containerType, "map");
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isContainer);
//    }
//
//    @Test(description = "convert a model with a map with complex list property")
//    public void mapWithListPropertyTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("translations",
//                        new MapProperty().additionalProperties(new ArrayProperty().items(new RefProperty("Pet"))))
//                .required("id");
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "a sample model");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "translations");
//        Assert.assertEquals(property.getter, "getTranslations");
//        Assert.assertEquals(property.setter, "setTranslations");
//        Assert.assertEquals(property.datatype, "Map<String, List<Pet>>");
//        Assert.assertEquals(property.name, "translations");
//        Assert.assertEquals(property.defaultValue, "new HashMap<String, List<Pet>>()");
//        Assert.assertEquals(property.baseType, "Map");
//        Assert.assertEquals(property.containerType, "map");
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isContainer);
//    }
//
//    @Test(description = "convert a model with a 2D list property")
//    public void list2DPropertyTest() {
//        final Model model = new ModelImpl().name("sample").property("list2D", new ArrayProperty().items(
//                new ArrayProperty().items(new RefProperty("Pet"))));
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "list2D");
//        Assert.assertEquals(property.getter, "getList2D");
//        Assert.assertEquals(property.setter, "setList2D");
//        Assert.assertEquals(property.datatype, "List<List<Pet>>");
//        Assert.assertEquals(property.name, "list2D");
//        Assert.assertEquals(property.defaultValue, "new ArrayList<List<Pet>>()");
//        Assert.assertEquals(property.baseType, "List");
//        Assert.assertEquals(property.containerType, "array");
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isContainer);
//    }
//
//    @Test(description = "convert a model with complex properties")
//    public void complexPropertiesTest() {
//        final Model model = new ModelImpl().description("a sample model")
//                .property("children", new RefProperty("#/definitions/Children"));
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "a sample model");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "children");
//        Assert.assertEquals(property.getter, "getChildren");
//        Assert.assertEquals(property.setter, "setChildren");
//        Assert.assertEquals(property.datatype, "Children");
//        Assert.assertEquals(property.name, "children");
//        Assert.assertEquals(property.defaultValue, "null");
//        Assert.assertEquals(property.baseType, "Children");
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isNotContainer);
//    }
//
//    @Test(description = "convert a model with complex list property")
//    public void complexListPropertyTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("children", new ArrayProperty().items(new RefProperty("#/definitions/Children")));
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "a sample model");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "children");
//        Assert.assertEquals(property.complexType, "Children");
//        Assert.assertEquals(property.getter, "getChildren");
//        Assert.assertEquals(property.setter, "setChildren");
//        Assert.assertEquals(property.datatype, "List<Children>");
//        Assert.assertEquals(property.name, "children");
//        Assert.assertEquals(property.defaultValue, "new ArrayList<Children>()");
//        Assert.assertEquals(property.baseType, "List");
//        Assert.assertEquals(property.containerType, "array");
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isContainer);
//    }
//
//    @Test(description = "convert a model with complex map property")
//    public void complexMapPropertyTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("children", new MapProperty().additionalProperties(new RefProperty("#/definitions/Children")));
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "a sample model");
//        Assert.assertEquals(cm.vars.size(), 1);
//        Assert.assertEquals(Sets.intersection(cm.imports, Sets.newHashSet("Map", "List", "Children")).size(), 3);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "children");
//        Assert.assertEquals(property.complexType, "Children");
//        Assert.assertEquals(property.getter, "getChildren");
//        Assert.assertEquals(property.setter, "setChildren");
//        Assert.assertEquals(property.datatype, "Map<String, Children>");
//        Assert.assertEquals(property.name, "children");
//        Assert.assertEquals(property.defaultValue, "new HashMap<String, Children>()");
//        Assert.assertEquals(property.baseType, "Map");
//        Assert.assertEquals(property.containerType, "map");
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isContainer);
//        Assert.assertFalse(property.isNotContainer);
//
//    }
//
//    @Test(description = "convert an array model")
//    public void arrayModelTest() {
//        final Model model = new ArrayModel()
//                .description("an array model")
//                .items(new RefProperty("#/definitions/Children"));
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "an array model");
//        Assert.assertEquals(cm.vars.size(), 0);
//        Assert.assertEquals(cm.parent, "ArrayList<Children>");
//        Assert.assertEquals(cm.imports.size(), 4);
//        Assert.assertEquals(Sets.intersection(cm.imports, Sets.newHashSet("ApiModel", "List", "ArrayList", "Children")).size(), 4);
//    }
//
//    @Test(description = "convert an map model")
//    public void mapModelTest() {
//        final Model model = new ModelImpl()
//                .description("an map model")
//                .additionalProperties(new RefProperty("#/definitions/Children"));
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.description, "an map model");
//        Assert.assertEquals(cm.vars.size(), 0);
//        Assert.assertEquals(cm.parent, "HashMap<String, Children>");
//        Assert.assertEquals(cm.imports.size(), 4);
//        Assert.assertEquals(Sets.intersection(cm.imports, Sets.newHashSet("ApiModel", "Map", "HashMap", "Children")).size(), 4);
//    }
//
//    @Test(description = "convert a model with upper-case property names")
//    public void upperCaseNamesTest() {
//        final Model model = new ModelImpl()
//                .description("a model with upper-case property names")
//                .property("NAME", new StringProperty())
//                .required("NAME");
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "NAME");
//        Assert.assertEquals(property.getter, "getNAME");
//        Assert.assertEquals(property.setter, "setNAME");
//        Assert.assertEquals(property.datatype, "String");
//        Assert.assertEquals(property.name, "NAME");
//        Assert.assertEquals(property.defaultValue, "null");
//        Assert.assertEquals(property.baseType, "String");
//        Assert.assertFalse(property.hasMore);
//        Assert.assertTrue(property.required);
//        Assert.assertTrue(property.isNotContainer);
//    }
//
//    @Test(description = "convert a model with a 2nd char upper-case property names")
//    public void secondCharUpperCaseNamesTest() {
//        final Model model = new ModelImpl()
//                .description("a model with a 2nd char upper-case property names")
//                .property("pId", new StringProperty())
//                .required("pId");
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "pId");
//        Assert.assertEquals(property.getter, "getPId");
//        Assert.assertEquals(property.setter, "setPId");
//        Assert.assertEquals(property.datatype, "String");
//        Assert.assertEquals(property.name, "pId");
//        Assert.assertEquals(property.defaultValue, "null");
//        Assert.assertEquals(property.baseType, "String");
//        Assert.assertFalse(property.hasMore);
//        Assert.assertTrue(property.required);
//        Assert.assertTrue(property.isNotContainer);
//    }
//
//    @Test(description = "convert a model starting with two upper-case letter property names")
//    public void firstTwoUpperCaseLetterNamesTest() {
//        final Model model = new ModelImpl()
//                .description("a model with a property name starting with two upper-case letters")
//                .property("ATTName", new StringProperty())
//                .required("ATTName");
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "ATTName");
//        Assert.assertEquals(property.getter, "getAtTName");
//        Assert.assertEquals(property.setter, "setAtTName");
//        Assert.assertEquals(property.datatype, "String");
//        Assert.assertEquals(property.name, "atTName");
//        Assert.assertEquals(property.defaultValue, "null");
//        Assert.assertEquals(property.baseType, "String");
//        Assert.assertFalse(property.hasMore);
//        Assert.assertTrue(property.required);
//        Assert.assertTrue(property.isNotContainer);
//    }
//
//    @Test(description = "convert hyphens per issue 503")
//    public void hyphensTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("created-at", new DateTimeProperty());
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "created-at");
//        Assert.assertEquals(property.getter, "getCreatedAt");
//        Assert.assertEquals(property.setter, "setCreatedAt");
//        Assert.assertEquals(property.name, "createdAt");
//    }
//
//    @Test(description = "convert query[password] to queryPassword")
//    public void squareBracketsTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("query[password]", new StringProperty());
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "query[password]");
//        Assert.assertEquals(property.getter, "getQueryPassword");
//        Assert.assertEquals(property.setter, "setQueryPassword");
//        Assert.assertEquals(property.name, "queryPassword");
//    }
//
//    @Test(description = "properly escape names per 567")
//    public void escapeNamesTest() {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property("created-at", new DateTimeProperty());
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("with.dots", model);
//
//        Assert.assertEquals(cm.classname, "WithDots");
//    }
//
//    @Test(description = "convert a model with binary data")
//    public void binaryDataTest() {
//        final Model model = new ModelImpl()
//                .description("model with binary")
//                .property("inputBinaryData", new ByteArrayProperty());
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "inputBinaryData");
//        Assert.assertEquals(property.getter, "getInputBinaryData");
//        Assert.assertEquals(property.setter, "setInputBinaryData");
//        Assert.assertEquals(property.datatype, "byte[]");
//        Assert.assertEquals(property.name, "inputBinaryData");
//        Assert.assertEquals(property.defaultValue, "null");
//        Assert.assertEquals(property.baseType, "byte[]");
//        Assert.assertFalse(property.hasMore);
//        Assert.assertFalse(property.required);
//        Assert.assertTrue(property.isNotContainer);
//    }
//
//    @Test(description = "translate an invalid param name")
//    public void invalidParamNameTest() {
//        final Model model = new ModelImpl()
//                .description("a model with a 2nd char upper-case property names")
//                .property("_", new StringProperty());
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        Assert.assertEquals(cm.name, "sample");
//        Assert.assertEquals(cm.classname, "Sample");
//        Assert.assertEquals(cm.vars.size(), 1);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, "_");
//        Assert.assertEquals(property.getter, "getU");
//        Assert.assertEquals(property.setter, "setU");
//        Assert.assertEquals(property.datatype, "String");
//        Assert.assertEquals(property.name, "u");
//        Assert.assertEquals(property.defaultValue, "null");
//        Assert.assertEquals(property.baseType, "String");
//        Assert.assertFalse(property.hasMore);
//        Assert.assertTrue(property.isNotContainer);
//    }
//
//    @Test(description = "convert a parameter")
//    public void convertParameterTest() {
//        final QueryParameter parameter = new QueryParameter()
//                .property(new IntegerProperty())
//                .name("limit")
//                .required(true);
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenParameter cm = codegen.fromParameter(parameter, null);
//
//        Assert.assertNull(cm.allowableValues);
//    }
//
//    @Test(description = "types used by inner properties should be imported")
//    public void mapWithAnListOfBigDecimalTest() {
//        final CodegenModel cm1 = new JavaClientCodegen().fromModel("sample", new ModelImpl()
//                .description("model with Map<String, List<BigDecimal>>")
//                .property("map", new MapProperty().additionalProperties(new ArrayProperty(new DecimalProperty()))));
//        Assert.assertEquals(cm1.vars.get(0).datatype, "Map<String, List<BigDecimal>>");
//        Assert.assertTrue(cm1.imports.contains("BigDecimal"));
//
//        final CodegenModel cm2 = new JavaClientCodegen().fromModel("sample", new ModelImpl()
//                .description("model with Map<String, Map<String, List<BigDecimal>>>")
//                .property("map", new MapProperty().additionalProperties(new MapProperty().additionalProperties(new ArrayProperty(new DecimalProperty())))));
//        Assert.assertEquals(cm2.vars.get(0).datatype, "Map<String, Map<String, List<BigDecimal>>>");
//        Assert.assertTrue(cm2.imports.contains("BigDecimal"));
//    }
//
//    @DataProvider(name = "modelNames")
//    public static Object[][] primeNumbers() {
//        return new Object[][] {
//                {"sample", "Sample"},
//                {"sample_name", "SampleName"},
//                {"sample__name", "SampleName"},
//                {"/sample", "Sample"},
//                {"\\sample", "Sample"},
//                {"sample.name", "SampleName"},
//                {"_sample", "Sample"},
//                {"Sample", "Sample"},
//        };
//    }
//
//    @Test(dataProvider = "modelNames", description = "avoid inner class")
//    public void modelNameTest(String name, String expectedName) {
//        final Model model = new ModelImpl();
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel(name, model);
//
//        Assert.assertEquals(cm.name, name);
//        Assert.assertEquals(cm.classname, expectedName);
//    }
//
//    @DataProvider(name = "classProperties")
//    public static Object[][] classProperties() {
//        return new Object[][] {
//                {"class", "getPropertyClass", "setPropertyClass", "propertyClass"},
//                {"_class", "getPropertyClass", "setPropertyClass", "propertyClass"},
//                {"__class", "getPropertyClass", "setPropertyClass", "propertyClass"}
//        };
//    }
//
//    @Test(dataProvider = "classProperties", description = "handle 'class' properties")
//    public void classPropertyTest(String baseName, String getter, String setter, String name) {
//        final Model model = new ModelImpl()
//                .description("a sample model")
//                .property(baseName, new StringProperty());
//        final DefaultCodegen codegen = new JavaClientCodegen();
//        final CodegenModel cm = codegen.fromModel("sample", model);
//
//        final CodegenProperty property = cm.vars.get(0);
//        Assert.assertEquals(property.baseName, baseName);
//        Assert.assertEquals(property.getter, getter);
//        Assert.assertEquals(property.setter, setter);
//        Assert.assertEquals(property.name, name);
//    }

}
