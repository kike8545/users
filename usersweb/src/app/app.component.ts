import {Component, OnInit, AfterViewInit, ViewChild, Inject} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatDialog} from '@angular/material/dialog';
import {MatTableDataSource} from '@angular/material/table';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {IdenDocType} from '../app/interfaces/IdenDocType';
import {User} from '../app/interfaces/User';
import {IdenDocTypeService} from '../app/services/iden-doc-type.service';
import {UserService} from '../app/services/users.service';
import {NotificationsService} from '../app/services/notifications.service';
import {DialogComponent} from './dialog/dialog.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  public form: FormGroup;
  public IDEN_DOC_TYPES: IdenDocType[] = [];
  public USERS: User[] = [];
  private url = 'http://localhost:8080/users/';
  resultsLength = 0;
  pageSize = 5;
  displayedColumns: string[] =
    ['firstName',
      'lastName',
      'mail',
      'phone',
      'idIdentityDocumentType',
      'identification',
      'edit'];
  dataSource: MatTableDataSource<User>;
  @ViewChild(MatPaginator, {static: false}) set matPaginator(paginator: MatPaginator) {this.dataSource.paginator = paginator;}
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  submitAttempt: boolean = false;

  constructor(private http: HttpClient,
    public dialog: MatDialog,
    private idenDocTypeService: IdenDocTypeService,
    private usersService: UserService,
    private notification: NotificationsService,
    private _FB: FormBuilder) {

    this.form = _FB.group({
      'firstName': ['', Validators.required],
      'lastName': ['', Validators.required],
      'mail': ['', Validators.email],
      'phone': ['', Validators.required],
      'idIdentityDocumentType': ['', Validators.required],
      'identification': ['', Validators.required]

    });
  }
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  ngOnInit() {
    this.findAll();
    this.findIdenDocTypes();
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  openDialog(user: User): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '350px',
      height: '650px',
      data: user
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');

    });
  }

  async addUser(form: any) {

    this.usersService.add(form)
      .subscribe(user => {
        this.notification.openNotification("Operación exitosas", "Datos guardados");
        this.form.reset();
        this.findAll();

      }, err => {
        this.notification.openNotification("Datos incompletos", err.error.message);
      });


  }
  async findAll() {

    this.usersService.findAll()
      .subscribe(users => {
        this.USERS = users;
        this.dataSource = new MatTableDataSource(this.USERS);
        this.resultsLength = this.USERS.length;

      }, err => {

      });
  }

  async findIdenDocTypes() {
    this.idenDocTypeService.findAll().subscribe(idenDocTypes => {
      this.IDEN_DOC_TYPES = idenDocTypes;

    }, err => {
      console.log(err);
    });

  }


}