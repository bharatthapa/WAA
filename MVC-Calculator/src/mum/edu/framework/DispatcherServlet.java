package mum.edu.framework;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mum.edu.framework.controller.Controller;
import mum.edu.framework.factory.DomainObjectFactory;

public class DispatcherServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 98279L;
  Map<String, Controller> controllers = new HashMap();
  Map<String, Controller> dispatchers = new HashMap();
  Map<String, String> dispatcherMethods = new HashMap();
  
  public void init()
    throws ServletException
  {
    String configFile = getServletConfig().getInitParameter("configFile");
    
    ConfigureServlet loadServletProperties = new ConfigureServlet();
    loadServletProperties.loadControllers(configFile, this.controllers, this.dispatchers, this.dispatcherMethods);
  }
  
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    process(request, response);
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    process(request, response);
  }
  
  private void process(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    String uri = request.getRequestURI();
    
    int lastIndex = uri.lastIndexOf("/");
    String action = uri.substring(lastIndex);
    
    System.out.println("action = " + action);
    
    String dispatchUrl = null;
    
    Controller controller = (Controller)this.dispatchers.get(action);
    System.out.println("controller = " + controller.getClass());
    String methodName = (String)this.dispatcherMethods.get(action);
    System.out.println("method = " + methodName);
    try
    {
      Class classObject = controller.getClass();
      Method method = null;
      Method[] arrayOfMethod;
      int j = (arrayOfMethod = classObject.getMethods()).length;
      for (int i = 0; i < j; i++)
      {
        Method m = arrayOfMethod[i];
        if (m.getName().equals(methodName))
        {
          method = m;
          System.out.println("=======================" + method);
          break;
        }
      }
      Object[] methodParams = new Object[method.getParameterTypes().length];
      int n = 0;
      
      Object domainObject = null;
      for (int i = 0; i < method.getParameterTypes().length; i++)
      {
        Class<?> paramClass = method.getParameterTypes()[i];
        if (paramClass == HttpServletRequest.class)
        {
          methodParams[(n++)] = request;
        }
        else if (paramClass == HttpServletResponse.class)
        {
          methodParams[(n++)] = response;
        }
        else
        {
          domainObject = DomainObjectFactory.getInstance(paramClass);
          
          methodParams[(n++)] = domainObject;
        }
      }
      if (request.getMethod().equals("POST")) {
        domainDataBinding(request, domainObject);
      }
      dispatchUrl = (String)method.invoke(controller, methodParams);
    }
    catch (Exception localException) {
    	localException.printStackTrace();
    	
    }
    if (dispatchUrl != null)
    {
      RequestDispatcher requestDispatcher = 
        request.getRequestDispatcher(dispatchUrl);
      requestDispatcher.forward(request, response);
    }
  }
  
  void domainDataBinding(HttpServletRequest request, Object domainObject)
  {
    Method domainMethod = null;
    Map parameterMap = request.getParameterMap();
    Enumeration parameterNames = request.getParameterNames();
    while (parameterNames.hasMoreElements())
    {
      String name = (String)parameterNames.nextElement();
      
      Object[] value = (Object[])parameterMap.get(name);
      
      name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
      String domainObjectSetter = "set" + name;
      
      Class[] parameterTypes = null;
      Method[] arrayOfMethod;
      int j = (arrayOfMethod = domainObject.getClass().getMethods()).length;
      for (int i = 0; i < j; i++)
      {
        Method m = arrayOfMethod[i];
        if (m.getName().equals(domainObjectSetter))
        {
          domainMethod = m;
          System.out.println("=======================" + m);
          break;
        }
      }
      parameterTypes = domainMethod.getParameterTypes();
      try
      {
        if (parameterTypes[0] == String.class)
        {
          domainMethod.invoke(domainObject, new Object[] { value[0] });
        }
        else if (parameterTypes[0] == Double.class)
        {
          String strVal = ((String)value[0]).trim();
          Double val = null;
          if (!strVal.isEmpty()) {
            val = Double.valueOf(strVal);
          }
          domainMethod.invoke(domainObject, new Object[] { val });
        }
        else if (parameterTypes[0] == Integer.class)
        {
          String strVal = ((String)value[0]).trim();
          Integer val = null;
          if (!strVal.isEmpty()) {
            val = Integer.valueOf(strVal);
          }
          domainMethod.invoke(domainObject, new Object[] { val });
        }
      }
      catch (Exception e)
      {
        System.out.println("BAD Data Bindind: " + e.getMessage());
      }
    }
  }
  
  void formDataBinding(HttpServletRequest request)
  {
    Object domainObject = request.getAttribute("model");
    Object formObject = null;
    String formName = domainObject.getClass().getName();
    formName = Character.toUpperCase(formName.charAt(0)) + formName.substring(1) + "Form";
    try
    {
      formObject = Class.forName(formName).getConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    Field[] domainfields = domainObject.getClass().getDeclaredFields();
    Field[] formfields = formObject.getClass().getDeclaredFields();
    Field[] arrayOfField1;
    int j = (arrayOfField1 = domainfields).length;
    for (int i = 0; i < j; i++)
    {
      Field domainField = arrayOfField1[i];
      
      Field formField = null;
      Field[] arrayOfField2;
      int m = (arrayOfField2 = formfields).length;
      for (int k = 0; k < m; k++)
      {
        Field fField = arrayOfField2[k];
        if (domainField.getType().equals(fField.getType()))
        {
          formField = fField;
          break;
        }
      }
      try
      {
        if (domainField.getType() == String.class)
        {
          formField.setAccessible(true);
          formField.set(formObject, domainField.get(domainObject));
        }
        else if (domainField.getType() == Double.class)
        {
          formField.setAccessible(true);
          formField.setDouble(formObject, domainField.getDouble(domainObject));
        }
      }
      catch (Exception e)
      {
        System.out.println("BAD Data Bindind: " + e.getMessage());
      }
    }
  }
}
