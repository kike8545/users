import {Component, OnInit, Input, Inject} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {IdenDocType} from '../interfaces/IdenDocType';
import {User} from '../interfaces/User';
import {NotificationsService} from '../services/notifications.service';
import {UserService} from '../services/users.service';


@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {


  public form: FormGroup;
  public IDEN_DOC_TYPES: IdenDocType[] = [];
  public USERS: User[] = [];

  constructor(public dialogRef: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: User,
    private usersService: UserService,
    private notification: NotificationsService,
    private http: HttpClient,
    private _FB: FormBuilder) {
    this.form = _FB.group({
      firstName: [data.firstName, Validators.required],
      lastName: [data.lastName, Validators.required],
      mail: [{value: data.mail, disabled: true}],
      phone: [data.phone, Validators.required],
      idIdentityDocumentType: [{value: data.idIdentityDocumentType, disabled: true}],
      identification: [{value: data.identification, disabled: true}]

    });

  }

  ngOnInit() {

  }

  async editUser(form: any) {
    this.data.firstName = form.firstName;
    this.data.lastName = form.lastName;
    this.data.phone = form.phone;

    this.usersService.edit(this.data)
      .subscribe(users => {

        this.notification.openNotification("Operación exitosas", "Datos guardados");
        this.form.reset();
        this.usersService.findAll();
        this.onNoClick();

      }, err => {
        this.notification.openNotification("Error al actualizar", err.error.message);
      });

  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
