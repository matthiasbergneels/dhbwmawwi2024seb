package excersises.chapter10.meldeamt;

import java.util.ResourceBundle;

enum Title {
  MRS, MR, DIVERS;

  @Override
  public String toString() {
    ResourceBundle uiLabelBundle = ResourceBundle.getBundle(CitizenRegistrationUtilities.UI_LABELS_RESOURCE_IDENTIFIER);
    switch (this) {
      case MR:
        return uiLabelBundle.getString("valuehelp_title_mr");
      case MRS:
        return uiLabelBundle.getString("valuehelp_title_mrs");
      case DIVERS:
        return uiLabelBundle.getString("valuehelp_title_divers");
    }
    return null;
  }
}
