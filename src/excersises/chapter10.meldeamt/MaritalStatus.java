package excersises.chapter10.meldeamt;

import java.util.ResourceBundle;

public enum MaritalStatus {
  SINGLE,
  MARRIED,
  WIDOWED,
  DIVORCED;

  @Override
  public String toString() {
    ResourceBundle uiLabelBundle = ResourceBundle.getBundle(CitizenRegistrationUtilities.UI_LABELS_RESOURCE_IDENTIFIER);
    switch (this) {
      case SINGLE:
        return uiLabelBundle.getString("valuehelp_marital_status_singel");
      case MARRIED:
        return uiLabelBundle.getString("valuehelp_marital_status_married");
      case WIDOWED:
        return uiLabelBundle.getString("valuehelp_marital_status_widowed");
      case DIVORCED:
        return uiLabelBundle.getString("valuehelp_marital_status_divorced");
    }
    return null;
  }
}
