import {Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {

  constructor(private notification: MatSnackBar) {}

  openNotification(message: string, action: string) {
    this.notification.open(message, action, {
      duration: 30000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
    });
  }
}
